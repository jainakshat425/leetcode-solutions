class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixSumCount = new HashMap();
        int sum = 0;
        int ans = 0;
        
        for(int num : nums) {
            sum += num;
            
            if( sum == k )
                ans++;
            
            ans += prefixSumCount.getOrDefault(sum-k, 0);
            
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0)+1);
        }
        
        return ans;
    }
}
