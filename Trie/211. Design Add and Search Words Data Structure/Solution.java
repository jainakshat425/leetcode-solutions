class WordDictionary {

    private TrieNode trieRoot;
    
    public WordDictionary() {
        trieRoot = new TrieNode();    
    }
    
    public void addWord(String word) {
        int n = word.length();
        TrieNode curr = trieRoot;
        for(int i=0; i<n; i++) {
            char currChar = word.charAt(i);
            
            if( !curr.containsKey(currChar) )
                curr.put(currChar, new TrieNode());
            
            curr = curr.get(currChar);
        }
        curr.setWordEnd(true);
    }
    
    public boolean search(String word) {
        return search(0, trieRoot, word);
    }
    
    private boolean search(int i, TrieNode curr, String word) {
        int n = word.length(); 
        
        if( curr == null )
            return false;
        
        if( i == n )
            return curr.isWordEnd();
        
        char currChar = word.charAt(i);
        
        if( currChar == '.' ) {
            for(char c='a'; c<='z'; c++) {
                if( curr.containsKey(c) && search(i+1, curr.get(c), word) ) 
                    return true;
            }
        }
        else if( curr.containsKey(currChar) )
            return search(i+1, curr.get(currChar), word);
        
        return false;
    }
}
class TrieNode {
    private static final int N = 26;
    private TrieNode[] links;
    private boolean wordEnd;
    
    public TrieNode() {
        links = new TrieNode[N];
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
    
    public void setWordEnd(boolean end) {
        this.wordEnd = end;
    }
    
    public boolean isWordEnd() {
        return this.wordEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
