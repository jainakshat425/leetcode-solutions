class WordFilter {

    private Trie trie;
    
    public WordFilter(String[] words) {
        int n = words.length;
        trie = new Trie();
        
        for(int i=0; i<n; i++) {
            int len = words[i].length();
            StringBuilder curr = new StringBuilder(words[i]);
            curr.insert(0, '#');
            
            // append character from the end of the word to the start of curr one-by-one
            for(int j=len-1; j>=0; j--) {
                curr.insert(0, words[i].charAt(j));
                trie.insert(curr.toString(), i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String searchTerm = suffix + '#' + prefix;
        return trie.startsWith(searchTerm);
    }
}
class TrieNode {
    private static final int N = 27;
    private TrieNode[] links;
    private int wordIndex;
    
    public TrieNode() {
        links = new TrieNode[N];
        wordIndex = -1;
    }
    
    private int charIndex(char c) {
        return c == '#' ? N-1 : c - 'a';
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
    
    public void setWordIndex(int ind) {
        wordIndex = ind;
    }
    
    public int getWordIndex() {
        return wordIndex;
    }
}
class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word, int ind) {
        int n = word.length();
        TrieNode curr = root;
        
        for(int i=0; i<n; i++) {
            char c = word.charAt(i);
            
            if( !curr.containsKey(c) ) 
                curr.put(c, new TrieNode());
            
            curr = curr.get(c);
            curr.setWordIndex(ind);
        }
    }
    
    public int startsWith(String prefix) {
        int n = prefix.length();
        TrieNode curr = root;
        
        for(int i=0; i<n; i++) {
            char c = prefix.charAt(i);
            
            if( !curr.containsKey(c) ) 
                return -1;
            
            curr = curr.get(c);
        }            
        return curr.getWordIndex();
    }
}
// class WordFilter {

//     private int n;
//     private String[] words;
//     private Trie trie;
    
//     public WordFilter(String[] words) {
//         this.n = words.length;
//         this.words = words;   
//         this.trie = new Trie();
        
//         for(int i=n-1; i>=0; i--) 
//             trie.insert(words[i], i);
//     }
    
//     public int f(String prefix, String suffix) {
//         return trie.search(prefix, suffix, words);
//     }
// }
// class TrieNode {
//     private static final int N = 26;
//     private TrieNode[] links;
//     private List<Integer> indices;
    
//     public TrieNode() {
//         links = new TrieNode[N];
//         indices = new ArrayList();
//     }
    
//     public boolean containsKey(char c) {
//         return links[c - 'a'] != null;
//     }
    
//     public TrieNode get(char c) {
//         return links[c - 'a'];
//     }
    
//     public void put(char c, TrieNode node) {
//         links[c - 'a'] = node;
//     }
    
//     public void addIndex(int ind) {
//         indices.add(ind);
//     }
    
//     public List<Integer> getIndices() {
//         return indices;
//     }
// }
// class Trie {
//     private TrieNode root;
    
//     public Trie() {
//         root = new TrieNode();
//     }
    
//     public void insert(String word, int ind) {
//         int n = word.length();
//         TrieNode curr = root;
        
//         for(int i=0; i<n; i++) {
//             char c = word.charAt(i);
            
//             if( !curr.containsKey(c) ) 
//                 curr.put(c, new TrieNode());
            
//             curr = curr.get(c);
//             curr.addIndex(ind);
//         }
//     }
    
//     public int search(String prefix, String suffix, String[] words) {
//         int n = prefix.length();
//         TrieNode curr = root;
        
//         for(int i=0; i<n; i++) {
//             char c = prefix.charAt(i);
            
//             if( !curr.containsKey(c) ) 
//                 return -1;
            
//             curr = curr.get(c);
//         }            
//         for(int ind : curr.getIndices()) {
//             if( words[ind].endsWith(suffix) )
//                 return ind;
//         }
//         return -1;
//     }
// }
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
