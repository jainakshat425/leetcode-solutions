class Solution {
    
    private static final char VISITED = '\0';
    
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        List<String> ans = new ArrayList();
        TrieNode root = buildTrie(words);
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) 
                findWords(i, j, board, root, ans);
        }
        return ans;
    }
    
    private void findWords(int i, int j, char[][] board, TrieNode curr, List<String> ans) {
        if( i < 0 || j < 0 || i == board.length || j == board[0].length )
            return;
                    
        char c = board[i][j];
        
        // return if current char is visited or trie doesn't contains such prefix
        if( c == VISITED || !curr.containsKey(c) ) 
            return;    

        
        curr = curr.get(c);
                
        if( curr.getWord() != null ) {
            ans.add( curr.getWord() );
            
            // to eliminate duplicates, mark current word as not a word
            curr.setWord(null);
        }
        
        // mark current character visited
        board[i][j] = VISITED;
        
        findWords(i+1, j, board, curr, ans); // up
        findWords(i-1, j, board, curr, ans); // bottom
        findWords(i, j-1, board, curr, ans); // left
        findWords(i, j+1, board, curr, ans); // right
        
        // backtrack - restore original character and original builder string
        board[i][j] = c;
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words)
            insert(root, word);
        return root;
    }
    
    public void insert(TrieNode root, String word) {
        int n = word.length();
        TrieNode curr = root;
        
        for(int i=0; i<n; i++) {
            char c = word.charAt(i);
            
            if( !curr.containsKey(c) ) 
                curr.put(c, new TrieNode());    
            
            curr = curr.get(c);
        }
        curr.setWord(word);
    }
}
class TrieNode {
    private static final int N = 26;
    private TrieNode[] links;
    private String word;
    
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
    
    public void setWord(String word) {
        this.word = word;
    }
    
    public String getWord() {
        return word;
    }
}
