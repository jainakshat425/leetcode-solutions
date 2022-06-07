class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for(int i=0; i<n; i++) {
            if( nums[i] <= 0 || nums[i] > n )
                nums[i] = n+1;
        }
        
        for(int i=0; i<n; i++) {
            int num = Math.abs(nums[i]);
            
            if( num == n+1 ) 
                continue;            
            
            if( nums[num-1] > 0 ) 
                nums[num-1] = -nums[num-1];            
        }
        
        for(int i=0; i<n; i++) {
            if( nums[i] > 0 )
                return i+1;
        }
        return n+1;
    }
}
