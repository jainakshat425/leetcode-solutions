class Solution {
    public int longestConsecutive(int[] nums) {
        // Create a hash set and add all the numbers into it
        Set<Integer> numSet = new HashSet<>();
        
        for(int num : nums) {
            numSet.add( num );
        }
        
        // Longest consecutive sequence
        int max = 0;
        
        // Iterate over each number in {nums} and if current number is lowest number of a consecutive sequence present in nums, then find the length of the consecutive sequence.
        for(int num : nums) {
            // If number-1 exist in the set, than don't start search for the longest consecutive sequence from this number.
            if( !numSet.contains( num-1 ) ) {
                
                // Current number is the smallest number of a consecutive sequence
                int count = 0;
                
                // While the next consecutive number is present in the set, keep incrementing number and count
                while( numSet.contains( num ) ) {
                    // Performance Optimization
                    // Remove num from set, as one number can only be part of one consecutive sequence
                    numSet.remove( num );
                    
                    count++;
                    num++;
                }

                // Update maximum, if current count is maximum
                if( count > max ) {
                    max = count;
                }
            }
            
            // Performance Optimization
            // If set become empty no need to continue as all the sequence are processed.
            if( numSet.isEmpty() ) {
                return max;
            }
        }
        
        return max;
    }
}
