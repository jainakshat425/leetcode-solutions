class Solution {
    public int search(int[] nums, int target) {
        /* 
        1. Declare {start} and {end} initialized with 0 and last index of array, respectively.
        2. Repeat while {start} < {end}
            - Find {mid}
            - If {target} is found at {mid}, return {mid}.
            - If left sub-array is sorted?
                - If target lies in the left sub-array, search in the left sub-array.
                - else target lies in the right sub-array, hence search in the right sub-array.
            - Else right sub-array is sorted and if target lies in the right sub-array
                - search in the right sub-array.
            - Else, search is the left sub-array.
        */
        
        // Declare {start} and {end} initialized with 0 and last index of array, respectively.
        int start = 0, end = nums.length-1;
        
        // Repeat while {start} < {end}
        while( start <= end ) {
            
            // Find {mid}
            int mid = start + (end-start)/2;
        
            // If {target} is found at {mid}, return {mid}.
            if( nums[mid] == target ) {
                return mid;
            }
            // If left sub-array is sorted?
            else if( nums[start] <= nums[mid] ) {

                // If target lies in the left sub-array
                if( target >= nums[start] && target < nums[mid] ) {
                    // search in the left sub-array.
                    end = mid-1;
                } else {
                    // else target lies in the right sub-array, hence search in the right sub-array.
                    start = mid+1;
                }
            }
            // Else right sub-array is sorted and if target lies in the right sub-array
            else if( target > nums[mid] && target <= nums[end] ) {
                // search in the right sub-array.
                start = mid+1;
            } 
            else {
                // search is the left sub-array.
                end = mid-1;
            }
        }
        
        return -1;
    }
}
