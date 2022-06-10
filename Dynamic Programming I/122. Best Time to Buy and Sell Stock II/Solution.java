class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // Index 1 > Buy, 0 > Sell
        int[] next = new int[2];
        int[] curr = new int[2];
        
        for(int day=n-1; day>=0; day--) {
            int notBuy = next[1];
            int buy = -prices[day] + next[0];

            curr[1] = Math.max(buy, notBuy);

            int notSell = next[0];
            int sell = prices[day] + next[1];

            curr[0] = Math.max(sell, notSell);
            
            next = curr;
        }
        return curr[1];
    }
}
/* 
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        
        for(int day=n-1; day>=0; day--) {
            int notBuy = dp[day+1][1];
            int buy = -prices[day] + dp[day+1][0];

            dp[day][1] = Math.max(buy, notBuy);

            int notSell = dp[day+1][0];
            int sell = prices[day] + dp[day+1][1];

            dp[day][0] = Math.max(sell, notSell);
        }
        return dp[0][1];
    }
}
*/
/*
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++) {
            dp[i][0] = dp[i][1] = -1;
        }
        return maxProfit(0, 1, n, prices, dp);
    }
    
    private int maxProfit(int day, int isBuy, int n, int[] prices, int[][] dp) {
        
        if( day == n )
            return 0;
        
        if( dp[day][isBuy] != -1 ) return dp[day][isBuy];
        
        int profit = 0;
        
        if( isBuy == 1 ) {
            int notBuy = maxProfit(day+1, 1, n, prices, dp);
            int buy = -prices[day] + maxProfit(day+1, 0, n, prices, dp);
            
            profit = Math.max(buy, notBuy);
        } else {
            int notSell = maxProfit(day+1, 0, n, prices, dp);
            int sell = prices[day] + maxProfit(day+1, 1, n, prices, dp);
            
            profit = Math.max(sell, notSell);
        }
        return dp[day][isBuy] = profit;
    }
}
*/
