class Solution {
        
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,LinkedList<String>> adj = new HashMap();
        LinkedList<String> ans = new LinkedList();
        Stack<String> stack = new Stack();
        
        // Create adjaceny list
        for(List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            
            adj.putIfAbsent(src, new LinkedList());
            adj.get(src).add(dest);
        }
        
        // Sort destinations
        for(List<String> neighbours : adj.values())
            neighbours.sort( (a,b) -> a.compareTo(b) ) ;
        
        stack.push("JFK");
        
        while( !stack.isEmpty() ) {
            String src = stack.pop();
            
            LinkedList<String> dests = adj.get(src);
            
            if( dests == null || dests.isEmpty() ) {
                ans.addFirst(src);
            } else {
                stack.push( src );
                stack.push( dests.removeFirst() );
            }
        }
        return ans;
    }
}
// class Solution {
        
//     public List<String> findItinerary(List<List<String>> tickets) {
//         Map<String,LinkedList<String>> adj = new HashMap();
//         LinkedList<String> ans = new LinkedList();
        
//         // Create adjaceny list
//         for(List<String> ticket : tickets) {
//             String src = ticket.get(0);
//             String dest = ticket.get(1);
            
//             adj.putIfAbsent(src, new LinkedList());
//             adj.get(src).add(dest);
//         }
        
//         // Sort destinations
//         for(List<String> neighbours : adj.values())
//             neighbours.sort( (a,b) -> a.compareTo(b) ) ;
        
//         // DFS each path, till all the tickets are used
//         dfs("JFK", adj, ans);
        
//         return ans;
//     }
    
//     private void dfs(String src, Map<String,LinkedList<String>> adj, LinkedList<String> ans) {
        
//         while( !adj.getOrDefault(src, new LinkedList()).isEmpty() ) 
//             dfs(adj.get(src).removeFirst(), adj, ans);
        
//         ans.addFirst(src);
//     }
// }

/* 
class Solution {
        
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> adj = new HashMap();
        LinkedList<String> ans = new LinkedList();
        
        // Create adjaceny list
        for(List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            
            adj.putIfAbsent(src, new LinkedList());
            adj.get(src).add(dest);
        }
        
        // Sort destinations
        for(List<String> neighbours : adj.values())
            neighbours.sort( (a,b) -> a.compareTo(b) ) ;
        
        // Start from JFK
        ans.add("JFK");
        
        // DFS each path, till all the tickets are used
        dfs("JFK", tickets.size() + 1, adj, ans);
        
        return ans;
    }
    
    private boolean dfs(String src, int n, Map<String,List<String>> adj, LinkedList<String> ans) {
        if( ans.size() == n )
            return true;
        
        if( !adj.containsKey(src) )
            return false;
        
        List<String> dests = new LinkedList(adj.get(src));
        
        for(String dest : dests) {
            adj.get(src).remove(dest);
            ans.add(dest);
            
            if( dfs(dest, n, adj, ans) )
                return true;
            
            ans.removeLast();
            adj.get(src).add(dest);
        }
        
        return false;
    }
}
*/
