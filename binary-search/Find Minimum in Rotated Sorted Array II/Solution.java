class Solution {
    public int findMin(int[] nums) {
        /* 
        1. Declare {start} and {end} initialized to 0 and last index of array, respectively.
        2. Repeat while {start} < {end}
            - Find {mid}
            - If {mid} element == element at the {end}, decrement end.
            - If {mid} element > element at {end}, then the minimum element exist in right half.
            - else search the minimum element in left half.
        */
        
        // Declare {start} and {end} initialized to 0 and last index of array, respectively.
        int start = 0, end = nums.length-1;
        
        // Repeat while {start} < {end}
        while( start < end ) {
            
            // Find {mid}
            int mid = start + (end-start)/2;
            
            // If {mid} element == element at the {end}, decrement end.
            if( nums[mid] == nums[end] ) {
                end--;
            } 
            // If {mid} element > element at {end}, then the minimum element exist in right half.
            else if( nums[mid] > nums[end] ) {
                start = mid+1;
            } else {
                // else search the minimum element in left half.
                end = mid;
            }
        }
        
        return nums[start];
    }
}
