class Solution {
    public int thirdMax(int[] nums) {
        /* 
        1. Create an array (maximums) to store three unique maximum values in desc order.
        2. Fill the array with minimum value.
        3. Iterate over numbers (nums)
            - Compare it with each element a[i] of (maximums).
            - If current number (num) is already present in (maximums) array, skip this number.
            - If current number (num) is greater than a[i] of (maximums).
                - Shift the elements of (maximums) to right and put current number (num) into the (maximums) array.
        4. If third maximum (maximums[2]) exists, return it.
        5. else return maximum (maximums[0]).
        */
        
        // Create an array (maximums) to store three unique maximum values in desc order.
        long[] maximums = new long[3];
        
        // Fill the array with minimum value.
        Arrays.fill(maximums, Long.MIN_VALUE);
        
        //  Iterate over numbers (nums)
        for(int num : nums) {
            
            // Compare it with each element a[i] of (maximums).
            for(int i=0; i<maximums.length; i++) {
                
                // If current number (num) is already present in (maximums) array, skip this number.
                if( num == maximums[i] ) {
                    break;
                }
                
                // If current number (num) is greater than a[i] of (maximums).
                if( num > maximums[i] ) {
                    
                    // Shift the elements of (maximums) to right. 
                    if( maximums[i] != Long.MIN_VALUE ) {
                        for(int j=maximums.length-1; j>i; j--) {
                            maximums[j] = maximums[j-1];
                        }
                    }
                    
                    // Put current number (num) into the (maximums) array. 
                    maximums[i] = num;
                    break;
                }
            }
        }
        
        // If third maximum (maximums[2]) exists, return it.
        if( maximums[2] != Long.MIN_VALUE ) {
            return new Long(maximums[2]).intValue();
        } else {
            // else return maximum (maximums[0]).
            return new Long(maximums[0]).intValue();
        }
    }
}
