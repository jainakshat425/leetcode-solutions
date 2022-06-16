class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[] next = new boolean[n];
        int start = 0, end = 0, maxLen = 1;
        
        for(int i=0; i<n; i++) {
            int len1 = longestPalindrome(i, i, n, s);
            int len2 = longestPalindrome(i, i+1, n, s);
            
            int len = Math.max(len1, len2);
            
            if( len > maxLen ) {
                start = i - (len-1)/2;
                end = i + len/2;
                maxLen = len;
            }
        }
        return s.substring(start, end+1);
    }
    
    private int longestPalindrome(int left, int right, int n, String s) {
        while( left >= 0 && right < n && s.charAt(left) == s.charAt(right) ) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
/* class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[] next = new boolean[n];
        int start = 0, end = 0, maxLen = 1;
        
        for(int i=n-1; i>=0; i--) {
            boolean[] curr = new boolean[n];
            for(int j=i; j<n; j++) {

                if( i == j ) {
                    curr[j] = true;
                    continue;
                }
                else if( (j-i == 1 ||  next[j-1] ) && s.charAt(i) == s.charAt(j) ) {
                    curr[j] = true;
                    if( j-i+1 > maxLen ) {
                        start = i;
                        end = j;
                        maxLen = j-i+1;
                    }
                }
            }
            next = curr;
        }  
        return s.substring(start, end+1);
    }
}
*/
/* 
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0, maxLen = 1;
        
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {

                if( i == j ) {
                    dp[i][j] = true;
                    continue;
                }
                else if( (j-i == 1 ||  dp[i+1][j-1] ) && s.charAt(i) == s.charAt(j) ) {
                    dp[i][j] = true;
                    if( j-i+1 > maxLen ) {
                        start = i;
                        end = j;
                        maxLen = j-i+1;
                    }
                }
            }
        }  
        return s.substring(start, end+1);
    }
}
*/
