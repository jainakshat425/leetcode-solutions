class Solution {
    public void nextPermutation(int[] nums) {
        
        int lastIndex = nums.length - 1;
        
        // Index of the first number from the last which is less than the next number
        // Numbers are after this index is sorted in non-increasing order and are already highest permutation.
        // Modifiying number at the pivot results in the next minimal higher permutation.
        int pivot = findPivot(nums);
        
        // If the current permutation is already highest (array is sorted in desc order)
        if( pivot == -1 ) {
            // Reverse array from 0th till last index to sort number is asc order.
            reverse(nums, 0, lastIndex);
            return;
        } 
        
        // Start index of the suffix 
        int suffixStart = pivot+1;
        
        // Find the index of least rightmost number greater than pivot number in the suffix
        int leastGreater = findLeastGreaterThan(nums, suffixStart, nums[pivot]);
        
        // Swap the number the pivot number with the least rightmost number greater than pivot number in the suffix
        // It will result in higher permutation (but it will not necessarily result in minimal higher permutation)
        // Since suffix is in non-increasing order
        swap(nums, pivot, leastGreater);
        
        // Reverse suffix so that it becomes sorted in non-decreasing order, resulting in minimal higher permutation
        reverse(nums, suffixStart, lastIndex);
    }
    
    private int findPivot(int[] nums) {
        int lastIndex = nums.length - 1;
        
        for(int curr=lastIndex; curr>0; curr--) {
            
            int prev = curr-1;
            
            if( nums[prev] < nums[curr] ) {
                return prev;
            }
        }
        
        // Array is sorted in descending order
        return -1;
    }
    
    private void reverse(int[] nums, int left, int right) {
        while( left < right ) {
            swap( nums, left, right );
            left++;
            right--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private int findLeastGreaterThan(int[] nums, int start, int val) {
        int lastIndex = nums.length - 1;  
        
        for(int curr = lastIndex; curr >= start; curr--) {
            
            if( nums[curr] > val ) {
                return curr;
            }
        }
        
        return -1;
    }
}
