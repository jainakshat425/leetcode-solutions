class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charOrder = new int[26];
        
        for(int i=0; i<order.length(); i++)
            charOrder[order.charAt(i) - 'a'] = i;
        
        for(int i=1; i<words.length; i++) 
            if( !isValid( words[i-1], words[i], charOrder ))
                return false;
        return true;
    }
    
    private boolean isValid(String word1, String word2, int[] charOrder) {
        int m = word1.length(), n = word2.length();
        int i = 0, j = 0;
        
        while( i < m && j < n ) {
            int ord1 = charOrder[word1.charAt(i++)-'a'];
            int ord2 = charOrder[word2.charAt(j++)-'a'];            
            
            if( ord1 != ord2 )
                return ord2 > ord1;
        }
        return m <= n;
    }
}
