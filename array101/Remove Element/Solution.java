class Solution {
    public int removeElement(int[] nums, int val) {
        /*
        1. Two Pointers Approach 
            - Fast Pointer or the Read Pointer (i)
            - Slow Pointer or the Write Pointer (j) 
        2. For each number which is not equal to val (the number to be removed)
            - Put it in the array using Write Pointer (j)
            - If the current value is val, then Read Pointer will be incremented
              but Write Pointer will stay the last non-val position.
        */
        
        int j = 0;
      
        for(int i=0; i<nums.length; i++)  {
          
            // For each number which is not equal to val (the number to be removed)
            if( nums[i] != val ) {
              
                // Put it in the array using Write Pointer (j)
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
