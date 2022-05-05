class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        // dp[i][j] is true if substring from i to j is palindrome
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        
        // length 1 substrings are palindrome
        for(int i=0; i<n; i++) {
            dp[i][i] = true;
        }
        
        int start = 0;
        
        // length 2 substring is palindrome if both characters are equal 
        for(int i=0; i<n-1; i++) {
            int j = i+1;
            if( s.charAt(i) == s.charAt(j) ) {
                dp[i][j] = true;
                
                maxLen = 2;
                start = i;
            }
        }
        
        /* length >2 substring is palindrome if the start and the end character
        of the substring are equal and the remaining substring is palindrome */
        for(int j=2; j<n; j++) {
            for(int i=0; i<n-j; i++) {
                
                int col = i+j;
                
                if( s.charAt(i) == s.charAt(col) && dp[i+1][col-1] ) {
                    dp[i][col] = true;
                
                    int len = col-i+1;

                    if( len > maxLen ) {
                        maxLen = len;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
}
