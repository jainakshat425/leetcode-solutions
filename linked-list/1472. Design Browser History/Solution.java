class BrowserHistory {
    private List<String> urls;
    private int pos, size;

    public BrowserHistory(String homepage) {
        urls = new ArrayList<String>(){{ add(homepage); }};
        pos = 0;
        size = 1;
    }
    
    public void visit(String url) {
        pos++;
        if( pos < urls.size() )
            urls.set(pos, url);
        else 
            urls.add(url);
        size = pos + 1;
    }
    
    public String back(int steps) {
        pos = Math.max(0, pos-steps);
        return urls.get(pos);
    }
    
    public String forward(int steps) {
        pos = Math.min(size-1, pos+steps);
        return urls.get(pos);
    }
}
// class BrowserHistory {
//     private Page curPage;

//     public BrowserHistory(String homepage) {
//         curPage = new Page(homepage);
//     }
    
//     public void visit(String url) {
//         Page newPage = new Page(url);
//         newPage.prev = curPage;
//         curPage.next = newPage;
//         curPage = newPage;
//     }
    
//     public String back(int steps) {
//         while( steps-- > 0 && curPage.prev != null ) 
//             curPage = curPage.prev;
//         return curPage.url;
//     }
    
//     public String forward(int steps) {
//          while( steps-- > 0 && curPage.next != null ) 
//             curPage = curPage.next;
//         return curPage.url;
//     }
// }
// class Page {
//     public String url;
//     public Page next, prev;
    
//     public Page(String url) {
//         this.url = url;
//     }
// }

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
