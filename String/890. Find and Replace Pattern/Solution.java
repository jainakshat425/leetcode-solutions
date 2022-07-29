class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        
        for(String word : words) {
            if( match(word, pattern) )
                ans.add( word );
        }
        return ans;
    }
    
    private boolean match(String word, String pattern) {
        int n = pattern.length();
        char[] charMap = new char[26];
        boolean[] mapped = new boolean[26];

        for(int i=0; i<n; i++) {

            char w = word.charAt(i), p = pattern.charAt(i);
            int wi = w-'a', pi = p-'a';

            if( charMap[wi] == '\0' ) {
                
                if( mapped[pi] ) 
                    return false;
                
                charMap[wi] = p;
                mapped[pi] = true;
            }
            
            if( charMap[wi] != p ) 
                return false;
        }
        return true;
    }
}
