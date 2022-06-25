class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i=1; i<=m; i++) {
            for(int j=n; j>=1; j--) {
                if( s.charAt(i-1) == t.charAt(j-1) ) 
                    dp[j] += dp[j-1];
            }
        }
        return dp[n];
    }
}
/* 
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++)
            dp[i][0] = 1;
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                dp[i][j] = dp[i-1][j];
                
                if( s.charAt(i-1) == t.charAt(j-1) ) 
                    dp[i][j] += dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}
*/
/* 
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        Integer[][] dp = new Integer[m+1][n+1];
        
        return countSubseq(m, n, s, t, dp);
    }
    
    private int countSubseq(int i, int j, String s, String t, Integer[][] dp) {
        
        if( j == 0 )
            return 1;
        
        if( i == 0 )
            return 0;
        
        if( dp[i][j] != null )
            return dp[i][j];
        
        int ways = 0;
        if( s.charAt(i-1) == t.charAt(j-1) ) 
            ways += countSubseq(i-1, j-1, s, t, dp);
            
        ways += countSubseq(i-1, j, s, t, dp);
            
        return dp[i][j] = ways;
    }
}
*/
