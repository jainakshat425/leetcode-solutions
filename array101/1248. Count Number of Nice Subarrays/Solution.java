class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int sum = 0;
        int[] prefixSumCount = new int[n+1];
        prefixSumCount[0] = 1;
        
        for(int i=0; i<n; i++) {
            sum += nums[i] & 1;
            
            if( sum >= k )
                ans += prefixSumCount[sum-k];
            
            prefixSumCount[sum] += 1;
        }
        return ans;
    }
}
