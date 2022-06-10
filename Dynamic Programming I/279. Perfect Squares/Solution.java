class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=1; j*j <= i; j++) {
                min = Math.min(min, 1 + dp[i-j*j]);
            }
            dp[i] = min;
        }
        
        return dp[n];
    }
}
/* 
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return minPartitions(n, dp);
    }
    
    private int minPartitions(int n, int[] dp) {
        if( n < 2 )
            return n;
        
        if( dp[n] != -1 ) 
            return dp[n];
        
        int min = Integer.MAX_VALUE;
        for(int i=1; i*i <= n; i++) {
            min = Math.min(min, 1 + minPartitions(n-i*i, dp));
        }
        return dp[n] = min;
    }
}
*/
