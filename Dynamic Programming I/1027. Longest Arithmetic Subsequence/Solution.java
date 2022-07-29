class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int ans = 1;
        Map<Integer,Integer>[] dp = new HashMap[n];
        
        for(int j=0; j<n; j++) {
            dp[j] = new HashMap();
            
            for(int i=0; i<j; i++) {
                int diff = nums[j] - nums[i];
                
                // num of times the same difference found for j
                int count = dp[i].getOrDefault(diff, 0) + 1;
                
                dp[j].put(diff, count);
                
                ans = Math.max(ans, count);
            }
        }
        return ans + 1;
    }
}
