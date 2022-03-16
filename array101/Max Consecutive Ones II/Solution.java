public class Solution {

    public static int maxConsecutiveOnes2(int[] nums, int k){
        /* 
        1. Create integer zeroFlipped to store the count of zeroes encountered while building up current maximum.
        2. For each number {num}, check if number is 1.
        3. If 1, increment current maxium {curr}.
        4. else if we've found atleast one 1 {curr > 0} (here current number is 0)
            - if we've flipped all maximum {k} zeroes
                - Compare current maximum with max, and update max accordingly.
                - Reset current maximum and zeros flipped to 0 for finding a new max.
            - else
                - flip one more zero
                - increment current maximum
        */
        
        int curr = 0, max = 0;
        // Create integer zeroFlipped to store the count of zeroes encountered while building up current maximum.
        int zeroFlipped = 0;
        

        for(int num : nums) {

            // For each number {num}, check if number is 1.
            if( num == 1 ) {
                
                //  If 1, increment current maxium {curr}.
                curr++;
              
            } else if( curr > 0 ) {
                // if we've flipped all maximum {k} zeroes
                if( zeroFlipped == k ) {
                  
                    // Compare current maximum with max, and update max accordingly.
                    if( curr > max ) {
                        max = curr;
                    }
                  
                    // Reset current maximum and zeros flipped to 0 for finding a new max.
                    curr = 0;
                    zeroFlipped = 0;
                } else {
                    // flip one more zero
                    zeroFlipped++;
                    // increment current maximum
                    curr++;
                }
            }
        }

        return max;
    }
}
