class Solution {
    public void moveZeroes(int[] nums) {
        /*
        1. Two Pointers Approach 
            - Fast Pointer or the Read Pointer (i)
            - Slow Pointer or the Write Pointer (j) 
        2. For each number which is not equal to 0 
            - Put it in the array using Write Pointer (j)
            - If the current value is 0, then Read Pointer will be incremented
              but Write Pointer will stay the last non-zero position.
        3. Set all the elements from Write Pointer to array length to 0. (shifting zeroes to right)
        */
        
        // Slow Pointer or the Write Pointer (j) 
        int j = 0;
        
        for(int i=0; i<nums.length; i++) {
            
            // For each number which is not equal to 0 
            if( nums[i] != 0 ) {
                // Put it in the array using Write Pointer (j)
                nums[j++] = nums[i];
            }
        }
        
        // Set all the elements from Write Pointer to array length to 0. (shifting zeroes to right)
        while( j < nums.length ) {
            nums[j++] = 0;
        }
    }
}
