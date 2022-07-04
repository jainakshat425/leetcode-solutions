class Solution {
    public int minDifficulty(int[] jobDifficulty, int days) {
        int n = jobDifficulty.length;
        
        if( n < days )
            return -1;
        
        int[][] dp = new int[n+1][days+1];
        
        dp[n-1][1] = jobDifficulty[n-1];
        for(int i=n-2; i>=0; i--) 
            dp[i][1] = Math.max(dp[i+1][1], jobDifficulty[i]);
        
        for(int i=0; i<days; i++)
            dp[n][i] = Integer.MAX_VALUE;
        
        for(int start=n-1; start>=0; start--) {
            for(int d=2; d<=days; d++) {
                int max = Integer.MIN_VALUE;
                dp[start][d] = Integer.MAX_VALUE;

                for(int i=start; i<n; i++) {
                    max = Math.max(max, jobDifficulty[i]);

                    if( dp[i+1][d-1] != Integer.MAX_VALUE )
                        dp[start][d] = Math.min(dp[start][d], max + dp[i+1][d-1]);
                }
            }
        }
        return dp[0][days];
    }   
}
// class Solution {
//     public int minDifficulty(int[] jobDifficulty, int d) {
//         int n = jobDifficulty.length;
        
//         if( n < d )
//             return -1;
        
//         int[][] dp = new int[n+1][d+1];
        
//         for(int[] row : dp)
//             Arrays.fill(row, -1);
        
//         return partitions(0, d, jobDifficulty, dp);
//     }
    
//     private int partitions(int start, int d, int[] nums, int[][] dp) {
        
//         if( start == nums.length ) return Integer.MAX_VALUE;
                
//         if( d == 1 ) return arrayMax(start, nums);
        
//         if( dp[start][d] != -1 ) return dp[start][d];
        
//         int max = Integer.MIN_VALUE;
//         int sum = Integer.MAX_VALUE;
        
//         for(int i=start; i<nums.length; i++) {
//             max = Math.max(max, nums[i]);
            
//             int rest = partitions(i+1, d-1, nums, dp);
            
//             if( rest != Integer.MAX_VALUE )
//                 sum = Math.min(sum, max + rest);
//         }
        
//         return dp[start][d] = sum;
//     }
    
//     private int arrayMax(int start, int[] nums) {
//         int max = Integer.MIN_VALUE;
//         for(int i=start; i<nums.length; i++)
//             max = Math.max(max, nums[i]);
//         return max;
//     }
// }
