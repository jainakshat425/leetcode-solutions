class Solution {
    public boolean canJump(int[] nums) {
        int dest = nums.length-1;
        
        if( dest == 0 )
            return true;
        
        int max = 0;        
        
        for(int i=0; i<dest; i++) {
            if( i > max )
                return false;
            
            max = Math.max(max, i+nums[i]);
            
            if( max >= dest )
                return true;
        }
        return false;
    }
}
/*class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        
        for(int i=n-1; i>=0; i--) {
            for(int len = nums[i]; len > 0; len--) {
                if( i+len < n && dp[i+len] ) {
                    dp[i] = true;
                    break;
                }                
            }
        }
        return dp[0];
    }
}*/
/*
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        return canJump(0, n-1, nums, dp) == 1;
    }
    
    private int canJump(int i, int n, int[] nums, int[] dp) {
        if( i >= n )
            return 1;
        
        if( dp[i] != 0 )
            return dp[i];
        
        int len = nums[i];
        while( len > 0 ) {
            if( canJump(i+len, n, nums, dp) == 1 )
                return 1;
            len--;
        }
        return dp[i] = -1;
    }
}*/
