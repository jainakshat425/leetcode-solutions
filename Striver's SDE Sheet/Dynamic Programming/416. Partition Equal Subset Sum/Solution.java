class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int num : nums)
            sum += num;
        
        if( sum % 2 != 0 )
            return false;
                
        return hasSubsetSum(nums, sum/2);
    }
    
    private boolean hasSubsetSum(int[] nums, int sum) {
        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        
        dp[0] = true;
        if( nums[0] <= sum ) 
            dp[nums[0]] = true;
        
        for(int i=1; i<n; i++) {
            for(int target=sum; target>=0; target--) {
                
                boolean notTake = dp[target];
                
                boolean take = false;
                if( nums[i] <= target ) 
                    take = dp[target-nums[i]];
                
                dp[target] = take || notTake;
            }
        }
        return dp[sum];
    }
}
/*
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        for(int num : nums)
            sum += num;
        
        if( sum % 2 != 0 )
            return false;
        
        sum /= 2;
        
        int[][] dp = new int[n][sum+1];
        
        for(int[] state : dp)
            Arrays.fill(state, -1);

        return hasSubsetSum(n-1, sum, nums, dp) == 1;
    }
    
    private int hasSubsetSum(int i, int target, int[] nums, int[][] dp) {
        if( target == 0 )
            return 1;
        
        if( i == 0 )
            return target == nums[0] ? 1 : 0;
        
        if( dp[i][target] != -1 ) 
            return dp[i][target];
        
        int notTake = hasSubsetSum(i-1, target, nums, dp);
        
        if( notTake == 1 ) 
            return dp[i][target] = 1;
        
        int take = 0;
        if( nums[i] <= target ) 
            take = hasSubsetSum(i-1, target - nums[i], nums, dp);
        
        return dp[i][target] = take;
    }
}*/
