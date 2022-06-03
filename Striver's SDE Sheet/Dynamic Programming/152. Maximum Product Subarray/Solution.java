class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0], max = nums[0], min = nums[0];
        
        for(int i=1; i<n; i++) {
            int prod1 = nums[i] * max;
            int prod2 = nums[i] * min;
            
            max = Math.max(prod1, Math.max(prod2, nums[i]));
            min = Math.min(prod1, Math.min(prod2, nums[i]));
            
            res = Math.max(res, Math.max( max, min ));
        }
        return res;
    }
}
