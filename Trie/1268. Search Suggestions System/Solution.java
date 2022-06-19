class Solution {
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int n = searchWord.length();
        List<List<String>> ans = new ArrayList(n);
        
        Arrays.sort(products);
        
        TrieNode trieRoot = buildTrie(products);
        TrieNode curr = trieRoot;
        
        for(int i=0; i<n; i++) {
            
            List<String> matches = new ArrayList(3);
                
            if( curr != null ) {
                char c = searchWord.charAt(i);
            
                if( curr.containsKey(c) ) {
                    curr = curr.get(c);

                    for(int ind : curr.getIndices()) 
                        matches.add( products[ind] );
                } else 
                    curr = null;
            } 
            ans.add( matches );
        }
        return ans;
    }
    
     public TrieNode buildTrie(String[] words) {
        int n = words.length;
        TrieNode root = new TrieNode();
         
        for(int i=0; i<n; i++)
            insert(root, words[i], i);
         
        return root;
    }
    
    public void insert(TrieNode root, String word, int index) {
        int n = word.length();
        TrieNode curr = root;
        
        for(int i=0; i<n; i++) {
            char c = word.charAt(i);
            
            if( !curr.containsKey(c) ) 
                curr.put(c, new TrieNode());    
            
            curr = curr.get(c);
            curr.addIndex(index);
        }
    }
}
class TrieNode {
    private static final int N = 26;
    private static final int MAX_INDICES = 3;
    private TrieNode[] links;
    private List<Integer> indices;
    
    public TrieNode() {
        links = new TrieNode[N];
        indices = new ArrayList(MAX_INDICES);
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
    
    public boolean addIndex(int index) {
        if( indices.size() == MAX_INDICES ) 
            return false;
        indices.add(index);
        return true;
    }
    
    public List<Integer> getIndices() {
        return indices;
    }
}
