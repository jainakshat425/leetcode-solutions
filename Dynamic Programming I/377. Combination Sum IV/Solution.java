class Solution {
    
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        for(int t=0; t<=target; t++) 
            for(int i=0; i<n; i++)
                if( nums[i] <= t )
                    dp[t] += dp[t - nums[i]];
        
        return dp[target];
    }
}
// class Solution {
//     public int combinationSum4(int[] nums, int target) {
//         int[] dp = new int[target+1];
//         Arrays.fill(dp, -1);
//         dp[0] = 1;
//         return comb(target, nums, dp);
//     }
    
//     private int comb(int target, int[] nums, int[] dp) {
//         if( dp[target] != -1 )
//             return dp[target];
        
//         dp[target] = 0;
        
//         for(int i=0; i<nums.length; i++)
//             if( nums[i] <= target )
//                 dp[target] += comb(target - nums[i], nums, dp);
        
//         return dp[target];
//     }
// }
