class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jump = 0, currEnd = 0, currFarthest = 0;
        
        for(int i=0; i<n-1; i++) {
            currFarthest = Math.max(currFarthest, i+nums[i]);
            
            if( i == currEnd ) {
                jump++;
                currEnd = currFarthest;
            }
        }
        return jump;
    }
}
/* 
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, (int)1e8);
        dp[n-1] = 0;
        
        for(int i=n-2; i>=0; i--) {
            if( i + nums[i] >= n-1 ) {
                dp[i] = 1;
                continue;
            }
            
            for(int j=nums[i]; j>0; j--) 
                dp[i] = Math.min(dp[i], dp[i+j] + 1);
        }
        return dp[0];
    }
}
*/
