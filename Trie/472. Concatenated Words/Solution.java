class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList();
        TrieNode root = new TrieNode();
        
        // Sort the strings according to length, so that we're not checking
        // if the shorter string can be formed by concatenation of longer strings
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));
        
        for(String wordStr : words) {
            // Convert to char array, so that substring is not required in DFS
            char[] word = wordStr.toCharArray();
            
            // DFS to check if current string can be formed by shorter strings
            if( isConcatenated(0, word, root) )
                ans.add( wordStr );
            
            // Add current string to trie
            trieInsert(root, word, 0, word.length);
        }
        return ans;
    }
    
    private boolean isConcatenated(int start, char[] word, TrieNode root) {
        int n = word.length;
        
        for(int i=start; i<n; i++) {
            // Check if the trie contains the prefix of the word
            
            TrieNode prefix = trieSearch(root, word, start, i);
            
            // If trie doesn't even contain the prefix, then we surely
            // cannot form this string 
            
            if( prefix == null ) break;
            
            // If some shorter word starts with the same prefix, we'll
            // increase the length of prefix and search again
            
            if( !prefix.isWord() ) continue;
            
            // If the prefix is found and it's valid word, search for the 
            // the remaining part (suffix) in the trie
            
            TrieNode suffix = trieSearch(root, word, i, n);
            if( suffix != null && suffix.isWord() ) 
                return true;
            
            // If trie contains prefix, but not the suffix, DFS for suffix
            // If suffix is found? memoize the solution by adding suffix to
            // trie and return true
            
            if( isConcatenated(i, word, root) ) {
                trieInsert(root, word, i, n);
                return true;
            }
        }
        return false;
    }
    
    private void trieInsert(TrieNode root, char[] word, int start, int end) {
        TrieNode curr = root;
        
        for(int i=start; i<end; i++) {            
            if( !curr.containsKey(word[i]) )
                curr.put(word[i], new TrieNode());
            
            curr = curr.get(word[i]);
        }
        curr.setIsWord(true);
    }
    
    private TrieNode trieSearch(TrieNode root, char[] word, int start, int end) {
        TrieNode curr = root;
        
        for(int i=start; i<end; i++) {
            if( !curr.containsKey(word[i]) )
                return null;
            
            curr = curr.get(word[i]);
        }
        return curr;   
    }
}
class TrieNode {
    private TrieNode[] links;
    private boolean isWord;
    
    public TrieNode() {
        links = new TrieNode[26];
    }
    
    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }
    
    public TrieNode get(char c) {
        return links[c - 'a'];
    }
    
    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }
    
    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }
    
    public boolean isWord() {
        return isWord;
    }
}
// class Solution {
//     public List<String> findAllConcatenatedWordsInADict(String[] words) {
//         int n = words.length;
//         List<String> ans = new ArrayList();
//         Set<String> dict = new HashSet();
        
//         Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));
        
//         for(String word : words) {
//             if( !dict.isEmpty() && isConcatenated(word, dict) )
//                 ans.add( word );
//             dict.add( word );
//         }
//         return ans;
//     }
    
//     private boolean isConcatenated(String word, Set<String> dict) {
//         int n = word.length();
        
//         for(int i=0; i<n; i++) {
//             String prefix = word.substring(0, i);
//             String suffix = word.substring(i, n);
            
//             if( dict.contains(prefix) )
//                 if( dict.contains(suffix) ) 
//                     return true;
//                 else if( isConcatenated(suffix, dict) ) 
//                     return dict.add(suffix);
//         }
//         return false;
//     }
// }
