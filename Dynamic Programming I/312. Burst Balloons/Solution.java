class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] nums2 = new int[n+2];
        nums2[0] = nums2[n+1] = 1;
        
        for(int i=0; i<n; i++)
            nums2[i+1] = nums[i];
        
        Integer[][] dp = new Integer[n+2][n+2];
        
        return maxCoins(1, n, nums2, dp);
    }
    
    private int maxCoins(int start, int end, int[] nums, Integer[][] dp) {
        if( start > end )
            return 0;
        
        if( dp[start][end] != null )
            return dp[start][end];
        
        int max = 0;
        
        for(int i=start; i<=end; i++) {            
            int coins = nums[start-1] * nums[i] * nums[end+1];
            coins += maxCoins(start, i-1, nums, dp);
            coins += maxCoins(i+1, end, nums, dp);
                        
            max = Math.max(max, coins);
        }
        return dp[start][end] = max;
    }
}
