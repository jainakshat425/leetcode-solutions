class AllOne {

    private Map<String,Integer> count;
    private Map<Integer,Node> freq;
    private Node head, tail;
    
    public AllOne() {
        count = new HashMap();
        freq = new HashMap();
        head = new Node(-1);
        tail = new Node(-1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        int curCnt = count.getOrDefault(key, 0);
        int newCnt = curCnt + 1;
        
        count.put(key, newCnt);
        
        addKeyToFreq(key, newCnt, curCnt);
        
        if( curCnt != 0 ) 
            removeKeyFromFreq(key, curCnt);
    }
    
    public void dec(String key) {
        int curCnt = count.get(key);
        int newCnt = curCnt - 1;
        
        if( newCnt == 0 )
            count.remove(key);     
        else {
            count.put(key, newCnt);
            addKeyToFreq(key, newCnt, curCnt);
        }
        
        removeKeyFromFreq(key, curCnt);
    }
    
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.getAnyKey();
    }
    
    public String getMinKey() {
        return head.next == tail ? "" : head.next.getAnyKey();
    }
    
    private void addKeyToFreq(String key, int cnt, int prevCnt) {
        if( freq.containsKey(cnt) ) {
            freq.get(cnt).addKey(key);
            return;
        } 
        
        Node newNode = new Node(cnt);
        freq.put(cnt, newNode);
        
        newNode.addKey(key);
        
        if( cnt > prevCnt ) {
            if( prevCnt == 0 ) 
                addNodeAfter(head, newNode);
            else
                addNodeAfter(freq.get(prevCnt), newNode);
        } else 
            addNodeBefore(freq.get(prevCnt), newNode);
    }
    
    private void removeKeyFromFreq(String key, int cnt) {
        Node node = freq.get(cnt);
        
        if( node.size() == 1 ) {
            delete(node);
            freq.remove(cnt);
        } else
            freq.get(cnt).removeKey(key);
    }
    
    private void addNodeAfter(Node prev, Node node) {
        addNode(prev, node, prev.next);
    }
    
    private void addNodeBefore(Node next, Node node) {
        addNode(next.prev, node, next);
    }
    
    private void addNode(Node prev, Node node, Node next) {
        node.next = next;
        node.prev = prev;
        
        prev.next = node;
        next.prev = node;
    }
    
    private void delete(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
}
class Node {
    public int count;
    public Set<String> keys;
    public Node prev, next;
    
    public Node(int count) {
        this.count = count;
        keys = new HashSet();
    }
    
    public String getAnyKey() {
        return keys.iterator().next();
    }
    
    public void addKey(String key) {
        keys.add(key);
    }
    
    public void removeKey(String key) {
        keys.remove(key);
    }
    
    public int size() {
        return keys.size();
    }
}
// class AllOne {

//     private HashMap<String,Integer> count;
//     private TreeMap<Integer,HashSet<String>> freq;
    
//     public AllOne() {
//         count = new HashMap();
//         freq = new TreeMap();
//     }
    
//     public void inc(String key) {
//         int curCnt = count.getOrDefault(key, 0);
//         int newCnt = curCnt + 1;
        
//         count.put(key, newCnt);
        
//         if( curCnt != 0 ) 
//             removeKeyFromFreq(key, curCnt);
        
//         addKeyToFreq(key, newCnt);
//     }
    
//     public void dec(String key) {
//         int curCnt = count.get(key);
//         int newCnt = curCnt - 1;
        
//         if( newCnt == 0 )
//             count.remove(key);     
//         else {
//             count.put(key, newCnt);
//             addKeyToFreq(key, newCnt);
//         }
        
//         removeKeyFromFreq(key, curCnt);
//     }
    
//     public String getMaxKey() {
//         return freq.isEmpty() ? "" : getAnyValueAtFreq( freq.lastKey() );
//     }
    
//     public String getMinKey() {
//         return freq.isEmpty() ? "" : getAnyValueAtFreq( freq.firstKey() );
//     }
    
//     private String getAnyValueAtFreq(int f) {
//         return freq.get(f).iterator().next();
//     }
    
//     private void addKeyToFreq(String key, int cnt) {
//         freq.putIfAbsent(cnt, new HashSet());
        
//         freq.get(cnt).add(key);
//     }
    
//     private void removeKeyFromFreq(String key, int cnt) {
//          HashSet<String> strs = freq.get(cnt);

//         if( strs.size() == 1 )
//             freq.remove(cnt);
//         else
//             strs.remove(key);
//     }
// }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
