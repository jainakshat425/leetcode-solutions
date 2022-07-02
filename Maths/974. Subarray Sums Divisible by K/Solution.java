class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[k];
        count[0] = 1;
        int sum = 0;
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            sum += nums[i];
            
            int remainder = sum % k;
            
            if( remainder < 0 )
                remainder += k;
            
            ans += count[remainder];
            
            count[remainder] += 1;
        }
        
        return ans;
    }
}
