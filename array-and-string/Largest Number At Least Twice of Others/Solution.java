class Solution {
    public int dominantIndex(int[] nums) {
        /* 
        1. Find maximum {max} and second maximum {secondMax} of all the numbers {nums}.
        2. Maintain pointer to the maximum number {i}.
        3. If maximum is greater than or equal to twice of the second maximum, return the pointer {i}.
        4. else, return -1.
        */
        
        int index = -1, max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++) {
            
            // Find maximum {max} and second maximum {secondMax} of all the numbers {nums}.
            if( nums[i] > max ) {
                
                secondMax = max;
                max = nums[i];
                
                // Maintain pointer to the maximum number {i}.
                index = i;
                
            } else if( nums[i] > secondMax ) {
                secondMax = nums[i];
            }
        }
        
        // If maximum is greater than or equal to twice of the second maximum, return the pointer {i}.
        if( max >= (secondMax*2)) {
            return index;
        }
        
        return -1;
    }
}
