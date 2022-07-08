class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] memo = new int[m][n+1][target+1];
        
        int total = paint(0, 0, target, houses, cost, memo);
        
        return total >= 1e8 ? -1 : total;
    }
    
    private int paint(int i, int prevColor, int target, int[] houses, int[][] cost, int[][][] memo) {
        if( i == houses.length )
            return target == 0 ? 0 : (int)1e8;
        
        if( target < 0 )
            return (int)1e8;
        
        if( memo[i][prevColor][target] != 0 )
            return memo[i][prevColor][target];
        
        // already painted
        if( houses[i] != 0 ) {
            int newTarget = (prevColor != houses[i]) ? target-1 : target;
            return paint(i+1, houses[i], newTarget, houses, cost, memo);
        }
        int min = Integer.MAX_VALUE;
        // try painting with each color
        for(int j=0; j<cost[i].length; j++) {
            
            int newTarget = (prevColor != j+1) ? target-1 : target;
            
            min = Math.min(min, cost[i][j] + paint(i+1, j+1, newTarget, houses, cost, memo));
        }
        return memo[i][prevColor][target] = min;
    }
}

// Not working
// class Solution {
//     public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
//         int[][][] dp = new int[m+1][n+1][target+1];
        
//         for(int i=m-1; i>=0; i--) {
//             for(int prevColor=n; prevColor>=0; prevColor--) {
//                 for(int t=1; t<=target; t++) {
//                      // already painted
//                     if( houses[i] != 0 ) {
//                         int newTarget = (prevColor != houses[i]) ? t-1 : t;
//                         dp[i][prevColor][t] = dp[i+1][houses[i]][newTarget];
//                     } else {
//                         int min = Integer.MAX_VALUE;
//                         // try painting with each color
//                         for(int j=0; j<cost[i].length; j++) {

//                             int newTarget = (prevColor != j+1) ? t-1 : t;

//                             min = Math.min(min, cost[i][j] + dp[i+1][j+1][newTarget]);
//                         }
//                         dp[i][prevColor][t] = min;
//                     }
//                 }
//             }
//         }
//         return dp[0][0][target] >= 1e8 ? -1 : dp[0][0][target];
//     }
// }
