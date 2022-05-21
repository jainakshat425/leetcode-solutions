class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];
        
        for(int amt=0; amt<=amount; amt++) {
            if( amt % coins[0] == 0 )
                prev[amt] = amt / coins[0];
            else 
                prev[amt] = (int)1e5;
        }
            
        for(int i=1; i<n; i++) {
            for(int amt=0; amt<=amount; amt++) {
                int notTake = prev[amt];
                int take = Integer.MAX_VALUE;
                if( coins[i] <= amt ) {
                    take = 1 + curr[amt-coins[i]];
                }
                curr[amt] = Math.min(take, notTake);   
            }
            prev = curr;
        }
        
        return prev[amount] >= 1e5 ? -1 : prev[amount];
    }
}
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int amt=0; amt<=amount; amt++) {
            if( amt % coins[0] == 0 )
                dp[0][amt] = amt / coins[0];
            else 
                dp[0][amt] = (int)1e5;
        }
            
        for(int i=1; i<n; i++) {
            for(int amt=0; amt<=amount; amt++) {
                int notTake = dp[i-1][amt];
                int take = Integer.MAX_VALUE;
                if( coins[i] <= amt ) {
                    take = 1 + dp[i][amt-coins[i]];
                }
                dp[i][amt] = Math.min(take, notTake);   
            }
        }
        
        return dp[n-1][amount] >= 1e5 ? -1 : dp[n-1][amount];
    }
}
*/
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int[] arr : dp) Arrays.fill(arr, -1);
        
        int count = coinChange(n-1, amount, coins, dp);
        
        return count >= 1e5 ? -1 : count;
    }
    
    private int coinChange(int i, int amt, int[] coins, int[][] dp) {
        if( i == 0 ) {
            if( amt % coins[i] == 0 )
                return amt / coins[i];
            else 
                return (int)1e5;
        }
        
        if( dp[i][amt] != -1 ) return dp[i][amt];
        
        int notTake = coinChange(i-1, amt, coins, dp);
        int take = Integer.MAX_VALUE;
        if( coins[i] <= amt ) {
            take = 1 + coinChange(i, amt-coins[i], coins, dp);
        }
        
        return dp[i][amt] = Math.min(take, notTake);
    }
}
*/
