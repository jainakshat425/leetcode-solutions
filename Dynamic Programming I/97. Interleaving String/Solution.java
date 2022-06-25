class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        if( m + n != s3.length() )
            return false;
        
        boolean[][] dp = new boolean[m+1][n+1];
        dp[m][n] = true;
        
        for(int i=m; i>=0; i--) {
            for(int j=n; j>=0; j--) {
                int k = i+j;
                
                if( i < m && s1.charAt(i) == s3.charAt(k) && dp[i+1][j] )
                    dp[i][j] = true;

                else if( j < n && s2.charAt(j) == s3.charAt(k) )
                    dp[i][j] = dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
/*
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        if( m + n != s3.length() )
            return false;
        
        int[][] dp = new int[m+1][n+1];
        
        return isInterleave(0, 0, s1, s2, s3, dp) == 1;
    }
    
    public int isInterleave(int i, int j, String s1, String s2, String s3, int[][] dp) {
        if( i == s1.length() && j == s2.length() )
            return 1;
        
        if( dp[i][j] != 0 )
            return dp[i][j];
        
        if( i < s1.length() && s1.charAt(i) == s3.charAt(i+j) )
            if( isInterleave(i+1, j, s1, s2, s3, dp) == 1 )
                return 1;
        
        if( j < s2.length() && s2.charAt(j) == s3.charAt(i+j) )
            if( isInterleave(i, j+1, s1, s2, s3, dp) == 1 )
                return 1;
        
        return dp[i][j] = -1;
    }
}*/
