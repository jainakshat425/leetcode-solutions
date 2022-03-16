class Solution {
    public int[] sortArrayByParity(int[] nums) {
         /*
        1. Two Pointers Approach 
            - Fast Pointer or the Read Pointer (i)
            - Slow Pointer or the Write Pointer (j) - Index at which next even element will be placed.
        2. For each number which is even
            - Swap it in the array using Write Pointer (j)
            - If the current value is odd, then Read Pointer will be incremented
              but Write Pointer will stay the last even position.
        */
      
        // Slow Pointer or the Write Pointer (j) - Index at which next even element will be placed.
        int j = 0;
        
        for(int i=0; i<nums.length; i++) {
            
            // For each number which is even
            if( nums[i] % 2 == 0 ) {
              
                // Swap it in the array using Write Pointer (j)
                swap( nums, i, j );
                j++;
            }
        }
        return nums;
    }
    
    private void swap(int[] nums, int i, int j) {
        if( i == j ) return;
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
