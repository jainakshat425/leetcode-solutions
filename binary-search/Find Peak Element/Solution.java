class Solution {
    public int findPeakElement(int[] nums) {
        /* 
        1. Declare {start} and {end} initialized to 0 and last index of array, respectively.
        2. Repeat while {start} < {end}
            - Find {mid}
            - If current element is in local increasing slope, search in right sub-array.
            - else current element is in local decreasing slope, search in left sub-array.
        */
        
        // Declare {start} and {end} initialized to 0 and last index of array, respectively.
        int start = 0, end = nums.length-1;

        // Declare {start} and {end} initialized to 0 and last index of array, respectively.
        while( start < end ) {
            
            // Find {mid}
            int mid = start + (end-start)/2;
            
            // If current element is in local increasing slope
            if( nums[mid] < nums[mid+1] ) {
                // search in right sub-array.
                start = mid+1;
            } else {
                // else current element is in local decreasing slope, search in left sub-array.
                end = mid;
            }
        }
        return start;
    }
}
