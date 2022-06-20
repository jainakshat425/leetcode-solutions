class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int skipFirst = rob(1, true, n, nums);
//         int robFirst = nums[0] + rob(1, false, n-1, nums);
//         return Math.max(skipFirst, robFirst);
//     }
    
//     private int rob(int i, boolean canRob, int n, int[] nums, int[] dp) {
//         if( i >= n )
//             return 0;
//         if( dp[i] != -1 ) return dp[i];
//         int notRob = rob(i+1, true, n, nums);
//         int rob = 0;
//         if( canRob )
//             rob = nums[i] + rob(i+1, false, n, nums);
        
//         return Math.max(notRob, rob);
//     }
    public int rob(int[] nums) {
        int n = nums.length;
        int skipFirst = rob(1, n, nums);
        int robFirst = nums[0] + rob(2, n-1, nums);
        return Math.max(skipFirst, robFirst);
    }
    
    private int rob(int start, int n, int[] nums) {
        int prev1 = 0, prev2 = 0;
        
        for(int i=start; i<n; i++) {
            int skip = prev1;
            int rob = nums[i] + prev2;
            
            int max = Math.max(skip, rob);
            
            prev2 = prev1;
            prev1 = max;
        }
        
        return prev1;
    }
}
