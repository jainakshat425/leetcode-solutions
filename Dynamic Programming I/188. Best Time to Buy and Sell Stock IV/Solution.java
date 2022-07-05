class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int m = k * 2; // total txns - Buy + Sell
        int[] dp = new int[m+1];
        
        for(int i=n-1; i>=0; i--) {
            for(int j=m; j>=1; j--) {
                
                boolean isBuy = j % 2 == 0;
        
                int noTxn = dp[j];
                int txn = dp[j-1];

                if( isBuy )
                    txn += -prices[i];
                else
                    txn += prices[i];

                dp[j] = Math.max(noTxn, txn);
            }
        }
        return dp[m];
    }
}
// class Solution {
//     public int maxProfit(int k, int[] prices) {
//         int n = prices.length;
//         int m = k * 2; // total txns - Buy + Sell
//         int[][] dp = new int[n+1][m+1];
        
//         for(int i=n-1; i>=0; i--) {
//             for(int j=1; j<=m; j++) {
                
//                 boolean isBuy = j % 2 == 0;
        
//                 int noTxn = dp[i+1][j];
//                 int txn = dp[i+1][j-1];

//                 if( isBuy )
//                     txn += -prices[i];
//                 else
//                     txn += prices[i];

//                 dp[i][j] = Math.max(noTxn, txn);
//             }
//         }
//         return dp[0][m];
//     }
// }
// class Solution {
//     public int maxProfit(int k, int[] prices) {
//         int n = prices.length;
//         int m = k * 2; // total txns - Buy + Sell
//         Integer[][] memo = new Integer[n][m+1];
//         return maxProfit(0, m, prices, memo);
//     }
    
//     private int maxProfit(int i, int k, int[] prices, Integer[][] memo) {
//         boolean isBuy = k % 2 == 0;
        
//         if( i == prices.length || k == 0 )
//             return 0;
        
//         if( memo[i][k] != null )
//             return memo[i][k];
        
//         int noTxn = maxProfit(i+1, k, prices, memo);
//         int txn = maxProfit(i+1, k-1, prices, memo);
        
//         if( isBuy )
//             txn += -prices[i];
//         else
//             txn += prices[i];
        
//         return memo[i][k] = Math.max(noTxn, txn);
//     }
// }
