class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        
        for(int cInd=0; cInd<n; cInd++) {            
            for(int amt=1; amt<=amount; amt++) {
                dp[amt] = dp[amt];

                if( coins[cInd] <= amt )
                    dp[amt] += dp[amt - coins[cInd]];
            }
        }
        
        return dp[amount];
    }
}
/* 
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        prev[0] = 1;
        
        for(int cInd=0; cInd<n; cInd++) {
            int[] curr = new int[amount+1];
            curr[0] = 1;
            
            for(int amt=1; amt<=amount; amt++) {
                curr[amt] = prev[amt];

                if( coins[cInd] <= amt )
                    curr[amt] += curr[amt - coins[cInd]];
            }
            prev = curr;
        }
        
        return prev[amount];
    }
}
*/
/* 
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return change(n-1, amount, coins);
    }
    
    private int change(int cInd, int amt, int[] coins) {
        if( amt == 0 )
            return 1;
        
        if( cInd == 0 )
            return amt % coins[cInd] == 0 ? 1 : 0;
            
        int notTake = change(cInd-1, amt, coins);
        int take = 0;
        
        if( coins[cInd] <= amt )
            take = change(cInd, amt - coins[cInd], coins);
        
        return take + notTake;
    }
}
*/
