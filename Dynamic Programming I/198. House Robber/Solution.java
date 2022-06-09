class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev2 = 0, prev1 = nums[0], curr = 0;
        
        for(int i=1; i<n; i++) {
            int rob = nums[i] + prev2;
            int notRob = prev1;

            curr = Math.max(rob, notRob);
            
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
/* 
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        for(int i=1; i<n; i++) {
            int rob = nums[i] + (i > 1 ? dp[i-2] : 0);
            int notRob = dp[i-1];

            dp[i] = Math.max(rob, notRob);
        }
        return dp[n-1];
    }
}
*/
/*
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return robMax(n-1, nums, dp);
    }
    
    private int robMax(int i, int[] nums, int[] dp) {
        if( i < 0 )
            return 0;
        
        if( i == 0 )
            return nums[i];
        
        if( dp[i] != -1 ) 
            return dp[i];
        
        int rob = nums[i] + robMax(i-2, nums, dp);
        int notRob = robMax(i-1, nums, dp);
        
        return dp[i] = Math.max(rob, notRob);
    }
}*/
