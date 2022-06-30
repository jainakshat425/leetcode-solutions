class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int median = n%2 == 1 ? nums[n/2] : (nums[n/2] + nums[(n-1)/2])/2;
        
        int ans = 0;
        
        for(int num : nums) 
            ans += Math.abs(num-median);
        
        return ans;
    }
}
