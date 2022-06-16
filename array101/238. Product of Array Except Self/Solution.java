class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // ans array itself work as suffix array
        int[] ans = new int[n];
        ans[n-1] = nums[n-1];
        int prefix = 1;
        
        for(int i=n-2; i>=0; i--) 
            ans[i] = ans[i+1] * nums[i];
        
        for(int i=0; i<n-1; i++) {
            ans[i] = prefix * ans[i+1];
            prefix *= nums[i];
        }
        ans[n-1] = prefix;
        return ans;
    }
}
/*
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int prefix = 1;
        int[] suffix = new int[n+1];
        suffix[n] = 1;
        
        for(int i=n-1; i>=0; i--) 
            suffix[i] = suffix[i+1] * nums[i];
        
        for(int i=0; i<n; i++) {
            ans[i] = prefix * suffix[i+1];
            prefix *= nums[i];
        }
        return ans;
    }
}
*/
