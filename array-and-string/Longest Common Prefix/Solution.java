class Solution {
    public String longestCommonPrefix(String[] strs) {
        /* 
        1. Find the string {lcp} with the shortest length, as the longest common prefix cannot be greater than the smallest string.
        2. For each string in the array {strs} and if current longest common prefix {lcp} has some characters.
            - find the lcp among current {lcp} and {strs[i]}
                - Take the smaller string among {lcp} and {strs[i]}
                - Iterate over characters of both
                    - If a mismatch founds, return the substring before the mismatch.
            - increment i to the next string.        
        */
        if( strs == null || strs.length == 0 ) {
            return null;
        }
        
        String lcp = strs[0];
        
        // Find the string {lcp} with the shortest length, as the longest common prefix cannot be greater than the smallest string.
        for(int j=0; j<strs.length; j++) {
            if( strs[j].length() < longest.length() ) {
                lcp = strs[j];
            }
        }
        
        int i = 0;
        
        // For each string in the array {strs} and if current longest common prefix {lcp} has some characters.   
        while( i < strs.length && lcp.length() > 0 ) {
            
            // find the lcp among current {lcp} and {strs[i]}
            lcp = findLongest( lcp, strs[i] );
            
            // increment i to the next string.   
            i++;
        }
        
        return lcp;
    }
    
    private String findLongest(String s1, String s2) {
        
        // Take the smaller string among {lcp} and {strs[i]}
        String smallerStr = s1.length() < s2.length() ? s1 : s2;
        
        
        // Iterate over characters of both
        for(int i=0; i<smallerStr.length(); i++) {
            
            // If a mismatch founds, return the substring before the mismatch.
            if( s1.charAt(i) != s2.charAt(i) ) {
                return smallerStr.substring(0, i);
            }
        }
        
        return smallerStr;
    }
}
