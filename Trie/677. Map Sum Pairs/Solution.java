class MapSum {
    private Map<String,Integer> strValues;
    private TrieNode root;
    
    public MapSum() {
        strValues = new HashMap();
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        int existingVal = strValues.getOrDefault(key, 0);
        strValues.put(key, val);
        trieInsert(key, val-existingVal);
    }
    
    public int sum(String prefix) {
        return triePrefixSum(prefix);
    }
    
    private void trieInsert(String key, int val) {
        int n = key.length();
        TrieNode curr = root;
        
        for(int i=0; i<n; i++) {
            char c = key.charAt(i);
            
            if( !curr.containsKey(c) ) 
                curr.put(c, new TrieNode());
            
            curr = curr.get(c);
            curr.addVal(val);
        }
    }
    
    private int triePrefixSum(String prefix) {
        int n = prefix.length();
        TrieNode curr = root;
        
        for(int i=0; i<n; i++) {
            char c = prefix.charAt(i);
            
            if( !curr.containsKey(c) ) 
                return 0;
            
            curr = curr.get(c);
        }
        return curr.getSum();
    }
}
class TrieNode {
    private static final int N = 26;
    private TrieNode[] links;
    private int sum;
    
    public TrieNode() {
        links = new TrieNode[N];
        sum = 0;
    }
    
    private int charIndex(char c) {
        return c - 'a';
    }
    
    public boolean containsKey(char c) {
        return links[charIndex(c)] != null;
    }
    
    public TrieNode get(char c) {
        return links[charIndex(c)];
    }
    
    public void put(char c, TrieNode node) {
        links[charIndex(c)] = node;
    }
    
    public void addVal(int val) {
        sum += val;
    }
    
    public int getSum() {
        return sum;
    }
}
/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
