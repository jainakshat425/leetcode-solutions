class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        List<List<Integer>> ans = new ArrayList();
        TrieNode root = new TrieNode();
        
        for(int i=0; i<n; i++) 
            trieInsert(root, words[i], i);
        
        for(int i=0; i<n; i++) 
            trieSearchPalindromes(root, i, words, ans);

        return ans;
    }
    
    private void trieInsert(TrieNode root, String key, int index) {
        int n = key.length();
        TrieNode curr = root;
        
        for(int i=n-1; i>=0; i--) {
            char c = key.charAt(i);
            
            if( !curr.containsKey(c) ) 
                curr.put(c, new TrieNode());
            
            curr = curr.get(c);
        }
        curr.setIndex(index);
    }

    private void trieSearchPalindromes(TrieNode root, int i, String[] words, List<List<Integer>> ans) {
        int n = words[i].length();
        TrieNode curr = root;
        
        for(int charInd=0; charInd<n && curr != null; charInd++) {
            char c = words[i].charAt(charInd);
            int j = curr.getIndex();
                
            if( j != -1 && j != i && isPalindrome(words[i], charInd, n-1) )
                ans.add(Arrays.asList(i, j));
            
            curr = curr.get(c);
        }
        if( curr != null )
            dfs(curr, i, n, words, ans);
    }
    
    private void dfs(TrieNode curr, int i, int n, String[] words, List<List<Integer>> ans) {
        
        int j = curr.getIndex();
        
        if( j != -1 && j != i && isPalindrome(words[j], 0, words[j].length()-n-1) )  
            ans.add(Arrays.asList(i, j));
        
        for(char c='a'; c<='z'; c++)
            if( curr.containsKey(c) )
                dfs(curr.get(c), i, n, words, ans);
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while( left < right )
            if( s.charAt(left++) != s.charAt(right--) )
                return false;
        return true;
    }
}
class TrieNode {
    private static final int N = 26;
    private TrieNode[] links;
    private int index;
    
    public TrieNode() {
        links = new TrieNode[N];
        index = -1;
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
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public int getIndex() {
        return index;
    }
}
