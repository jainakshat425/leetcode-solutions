class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        int n = sentence.length();
        TrieNode root = new TrieNode();
        StringBuilder ans = new StringBuilder();
        
        for(String word : dictionary) 
            trieInsert(root, word);
        
        int left = 0; 
        
        for(int right=0; right<=n; right++) {
            if( right != n && sentence.charAt(right) != ' ' )
                continue;
            
            ans.append(trieSearchRoot(root, sentence, left, right));
            if(right != n)
                ans.append(" ");
            left = right+1;
        }
        return ans.toString();
    }
    
    private String trieSearchRoot(TrieNode root, String sentence, int left, int right) {
        TrieNode curr = root;
        
        for(int i=left; i<right; i++) {
            char c = sentence.charAt(i);
            
            if( !curr.containsKey(c) ) 
                return sentence.substring(left, right);
            
            curr = curr.get(c);
            
            if( curr.isRoot() )
                return sentence.substring(left, i+1);;
        }
        return sentence.substring(left, right);
    }
    
    private void trieInsert(TrieNode root, String key) {
        int n = key.length();
        TrieNode curr = root;
        
        for(int i=0; i<n; i++) {
            char c = key.charAt(i);
            
            if( !curr.containsKey(c) ) 
                curr.put(c, new TrieNode());
            
            curr = curr.get(c);
        }
        curr.setRoot(true);
    }
}
class TrieNode {
    private static final int N = 26;
    private TrieNode[] links;
    private boolean isRoot;
    
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
    
    public void setRoot(boolean isRoot) {
        this.isRoot = isRoot;
    }
    
    public boolean isRoot() {
        return isRoot;
    }
}
/* 
n = length of sentence
m = number of words in dict
k = length of dict word

iterate over each word in sentence
    - iterate over each root in dictionary
        - check if curr word starts with root
            - replace it with the smallest such root
 
Time - O(n) + O(nmk)
Space - O(n)

store dict words in trie
iterate over each word in sentence
    - search it's root in trie

Time - O(mk) + O(n) + O(nk)
Space = TrieSpace + 
*/
