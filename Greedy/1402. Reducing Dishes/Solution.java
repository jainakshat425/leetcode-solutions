class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        // sum of satisfication from end till curr index
        int sum = 0;
        // sum of like-time coeff from end till curr index
        int coeffSum = 0;
        // max of sum of like-time coeff from end till curr index
        int max = 0;  
        
        Arrays.sort(satisfaction);
        
        for(int i=n-1; i>=0; i--) {
            sum += satisfaction[i];
            coeffSum += sum;
            max = Math.max(max, coeffSum);
        }
        return max;
    }
}

// class Solution {
//     public int maxSatisfaction(int[] satisfaction) {
//         int n = satisfaction.length;
//         int[][] dp = new int[n+1][n+2];
        
//         Arrays.sort(satisfaction);
        
//         for(int i=n-1; i>=0; i--) {
//             for(int t=n; t>=1; t--) {
//                 int notTake = dp[i+1][t];
//                 int take = t * satisfaction[i] + dp[i+1][t+1];
//                 dp[i][t] = Math.max(notTake, take);
//             }
//         }
//         return Math.max(0, dp[0][1]);
//     }
// }

// class Solution {
//     public int maxSatisfaction(int[] satisfaction) {
//         int n = satisfaction.length;
//         int[][] dp = new int[n][n+1];
        
//         Arrays.sort(satisfaction);
        
//         for(int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);
        
//         return Math.max(0, maxSatisfy(0, 1, satisfaction, dp));
//     }
    
//     private int maxSatisfy(int dishInd, int time, int[] satisfaction, int[][] dp) {
//         int n = satisfaction.length;
        
//         if( dishInd == n )
//             return 0;
        
//         if( dp[dishInd][time] != Integer.MIN_VALUE )
//             return dp[dishInd][time];
        
//         int max = Integer.MIN_VALUE;
//         for(int i=dishInd; i<n; i++) {
//             // like-time coefficient
//             int coeff = time * satisfaction[i];
//             max = Math.max(max, coeff + maxSatisfy(i+1, time+1, satisfaction, dp));
//         }
//         return dp[dishInd][time] = max;
//     }
// }
