class WordFilter {

    private Trie trie;
    
    public WordFilter(String[] words) {
        int n = words.length;
        trie = new Trie();
        
        for(int i=0; i<n; i++) {
			// for word = abc, store in trie -> c#abc, bc#abc, abc#abc
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
	// 26 for lowercase letters and 1 for # (stored at last index)
    private static final int N = 27;
    private TrieNode[] links;
    private int wordIndex;
    
    public TrieNode() {
        links = new TrieNode[N];
		// at any time, it will store the index of the last word which has the current prefix
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
