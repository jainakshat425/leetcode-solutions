class Solution {
    public int search(int[] nums, int target) {
        /* 
        1. Since array is sorted, find middle element of array.
            - If middle element = target, return middle index.
            - If middle element < target, search in the elements after mid.
            - else middle element > target, search in the elements before mid.
        */
        int start = 0, end = nums.length-1;
        int mid;
        
        // Since array is sorted, find middle element of array.
        while( start <= end ) {
            mid = (start+end)/2;
            
            // If middle element = target, return middle index.
            if( nums[mid] == target ) {
                return mid;
            } else if( nums[mid] < target )  {
                // If middle element < target, search in the elements after mid.
                start = mid+1;
            } else {
                // else middle element > target, search in the elements before mid.
                end = mid-1;
            }
        }
        return -1;
    }
}
