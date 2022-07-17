class Solution {
    private static final int MAX = 1000000007;
    
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=k; j++) {
                if( j == 0 )
                    dp[i][j] = 1;
                else {
                    int inv = (dp[i-1][j] + MAX - (j >= i ? dp[i-1][j-i] : 0)) % MAX;

                    dp[i][j] = (dp[i][j-1] + inv) % MAX;
                }
            }
        }
        return (dp[n][k] + MAX - (k > 0 ? dp[n][k-1] : 0)) % MAX;
    }
}
// class Solution {
    
//     private Integer[][] memo =  new Integer[1001][1001];
//     private static final int MAX = 1000000007;
    
//     public int kInversePairs(int n, int k) {
//         if( n == 0 )
//             return 0;
//         if( k == 0 )
//             return 1;
        
//         if( memo[n][k] != null )
//             return memo[n][k];
        
//         int inv = 0;
        
//         for(int p=0; p<=Math.min(k, n-1); p++) 
//             inv = (inv + kInversePairs(n-1, k-p)) % MAX;
        
//         return memo[n][k] = inv;
//     }
// }
