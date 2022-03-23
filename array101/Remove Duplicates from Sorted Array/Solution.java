class Solution {
    public int removeDuplicates(int[] nums) {
        /*
        1. Two Pointers Approach 
            - Fast Pointer or the Read Pointer (i)
            - Slow Pointer or the Write Pointer (j) 
        2. For each number which is not equal to previous number (unique number)
            - Put it in the array using Write Pointer (j)
            - If the current value is a duplicate of previous value, then Read Pointer will be incremented
              but Write Pointer will stay at the last unique value.
        */
        
        // Slow Pointer or the Write Pointer (j) 
        int j = 0;
        
        for(int i=1; i<nums.length; i++) {
            
            // For each number which is not equal to previous number (unique number)
            if( nums[i] != nums[i-1] ) {
                
                // Put it in the array using Write Pointer (j)
                nums[++j] = nums[i];
            }
        }
      
        // j is the index of the last element, and j+1 is the total number of elements.
        return j+1;
    }
}
