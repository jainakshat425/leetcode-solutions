class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int low = 0, high = nums.length-1;
        
        while( low != high ) {
            
            int mid = low + (high-low)/2;

            // boolean isMidEven = mid % 2 == 0;
            
            /* Is mid even and next number equal or
            mid is odd and previous number equal */
            if( 
                (isMidEven && nums[mid] == nums[mid+1]) ||
                (!isMidEven && nums[mid] == nums[mid-1])
            ) {
                /* All the number before the mid appear twice,
                reduce the search space to numbers after mid */
                low = mid+1;
            } else {
                /* The single number appears before mid */
                high = mid;
            }
        }
        
        return nums[low];
    }
    
}
