class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        dp[n][0] = dp[n+1][0] = (int)-1e8;
        
        for(int day=n-1; day>=0; day--) {
            
            int notBuy = dp[day+1][1];
            int buy = -prices[day] + dp[day+1][0];

            dp[day][1] = Math.max(notBuy, buy);

            int notSell = dp[day+1][0];
            int sell = prices[day] + dp[day+2][1];

            dp[day][0] = Math.max(notSell, sell);
        }
        return dp[0][1];
    }
}
/* 
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return maxProfit(0, true, false, prices);
    }
    
    private int maxProfit(int day, boolean canBuy, boolean cooldown, int[] prices) {
        if( day == prices.length ) 
            return canBuy ? 0 : (int)-1e8;
        
        int profit = 0;
        if( canBuy ) {
            int notBuy = maxProfit(day+1, true, false, prices);
            int buy = 0;
            
            if( !cooldown ) 
                buy = -prices[day] + maxProfit(day+1, false, false, prices);
            
            profit = Math.max(notBuy, buy);
        } else {
            int notSell = maxProfit(day+1, false, false, prices);
            int sell = prices[day] + maxProfit(day+1, true, true, prices);
            
            profit = Math.max(notSell, sell);
        }
        return profit;
    }
}
*/
