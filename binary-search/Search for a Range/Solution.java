class Solution {
    public int[] searchRange(int[] nums, int target) {
        /* 
        1. Find an return the first and last occurance of {target} using binary search with two seperate methods.
        */
        return new int[]{
           first(nums, 0, nums.length-1, target),
           last(nums, 0, nums.length-1, target)
        };
    }
    
    public int first(int[] nums, int start, int end, int target) {
        int ans = -1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            
            if( nums[mid] == target ) {
                ans = mid;
                end = mid-1;
            } else if( nums[mid] > target ) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }
    
    public int last(int[] nums, int start, int end, int target) {
        int ans = -1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if( nums[mid] == target ) {
                ans = mid;
                start = mid+1;
            } else if( nums[mid] > target ) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }
        
}
