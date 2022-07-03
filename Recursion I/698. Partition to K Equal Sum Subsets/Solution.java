class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        
        if( sum % k != 0 )
            return false;
        
        Arrays.sort(nums);
        
        return subsetSum(n-1, 0, sum / k, k, nums);
    }
    
    private boolean subsetSum(int start, int sum, int target, int k, int[] nums) {
        if( k == 0 )
            return true;
    
        if( sum == target ) 
            return subsetSum(nums.length-1, 0, target, k-1, nums);
        
        for(int i=start; i>=0; i--) {
            int num = nums[i];
            
            if( num == -1 || sum + num > target ) 
                continue;
            
            nums[i] = -1;
            if( subsetSum(i-1, sum + num, target, k, nums) ) 
                return true;
            nums[i] = num;
        }
        return false;
    }
}
// class Solution {
//     public boolean canPartitionKSubsets(int[] nums, int k) {
//         int n = nums.length;
//         int sum = Arrays.stream(nums).sum();
        
        
//         if( sum % k != 0 )
//             return false;
        
//         return subsetSum(0, 0, sum / k, k, nums);
//     }
    
//     private boolean subsetSum(int start, int sum, int target, int k, int[] nums) {
//         if( k == 0 )
//             return true;
    
//         if( sum == target ) 
//             return subsetSum(0, 0, target, k-1, nums);
        
//         for(int i=start; i<nums.length; i++) {
//             int num = nums[i];
            
//             if( num == -1 || sum + num > target ) 
//                 continue;
            
//             nums[i] = -1;
//             if( subsetSum(i+1, sum + num, target, k, nums) ) 
//                 return true;
//             nums[i] = num;
//         }
//         return false;
//     }
// }
