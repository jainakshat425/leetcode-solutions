class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[5];
        dp[1] = dp[3] = prices[n-1];
        
        for(int i=n-2; i>=0; i--) {            
            for(int txn=0; txn<4; txn++) {
                boolean isBuyTxn = txn % 2 == 0;

                int noAction = dp[txn];
                int action = dp[txn+1];
                
                action += isBuyTxn ? -prices[i] : prices[i];
                
                dp[txn] = Math.max(action, noAction);
            }
        }
        
        return dp[0];
    }
}
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n][5];
//         dp[n-1][1] = dp[n-1][3] = prices[n-1];
        
//         for(int i=n-2; i>=0; i--) {
//             for(int txn=3; txn>=0; txn--) {
//                 boolean isBuyTxn = txn % 2 == 0;

//                 int noAction = dp[i+1][txn];
                
//                 if( isBuyTxn ) {
//                     int buy = -prices[i] + dp[i+1][txn+1];
//                     dp[i][txn] = Math.max(buy, noAction);
//                 } else {
//                     int sell = prices[i] + dp[i+1][txn+1];
//                     dp[i][txn] = Math.max(sell, noAction);
//                 }
//             }
//         }
        
//         return dp[0][0];
//     }
// }
// class Solution {
//     public int maxProfit(int[] prices) {
//         return maxProfit(0, 0, prices);
//     }
    
//     private int maxProfit(int i, int txn, int[] prices) {
        
//         if( txn == 4 )
//             return 0;
        
//         boolean isBuyTxn = txn % 2 == 0;
        
//         if( i == prices.length - 1 )
//             return !isBuyTxn ? prices[i] : 0;
        
//         if( isBuyTxn ) {
//             int notBuy = maxProfit(i+1, txn, prices);
//             int buy = -prices[i] + maxProfit(i+1, txn+1, prices);
            
//             return Math.max(buy, notBuy);
//         } else {
//             int notSell = maxProfit(i+1, txn, prices);
//             int sell = prices[i] + maxProfit(i+1, txn+1, prices);
            
//             return Math.max(sell, notSell);
//         }
//     }
// }
