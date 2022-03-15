class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        /*
        1. Declare integers currMax and max, intialized to 0.
        2. Iterate over nums
        3. If current number is 1, increment currMax.
        4. else (current number is 0), check if currMax > max.
        5. If so, update max to currMax. 
        6. Update currMax to 0 (so to start finding new consecutive 1's).
        7. To handle the case where max consecutives 1 are at the end of the array,
           check if currMax > max again to update the value of max.
        */
        
        // Declare integers currMax and max, intialized to 0.
        int currMax = 0, max = 0;

        // Iterate over nums
        for(int num : nums) {
            // If current number is 1, increment currMax.
            if( num == 1 ) {
                currMax++;
            } else {
                // else (current number is 0), check if currMax > max.
                if( currMax > max ) {
                    max = currMax;
                }
                // Update currMax to 0 (so to start finding new consecutive 1's).
                currMax = 0;
            }
        }
        
        // To handle the case where max consecutives 1 are at the end of the array,
        // check if currMax > max again to update the value of max.
        if( currMax > max ) {
            max = currMax;
        }
        return max;
    }
}
