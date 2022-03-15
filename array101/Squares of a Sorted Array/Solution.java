class Solution {
    public int[] sortedSquares(int[] nums) {
        /* 
        1. Since the numbers are already sorted, we need to find a breakpoint from where 
            the numbers start increasing again (this will happen iff there are negative numbers in the array).
        2. Square all the numbers by iterating over them and check if the previous number  
            was greater than the current number.
        3. If breakpoint is 0, that means there array is already sorted and we can return it.
        4. Use merge sort technique to iterate over subarrays.
        5. Maintain pointer on each subarray and compare numbers from each subarray.
        6. Lower number will go into the sorted array and index for the respective subarray and sorted array will be incremented.
        7. It might happen that after initial iteration one of the subarray get left with some elements.
        8. Iterate over the subarray individually to put remaining numbers into the sorted array.
        */
        
        // Since the numbers are already sorted, we need to find a breakpoint from where 
        // the numbers start increasing again.
        int brkPoint = 0;
        
        // Square all the numbers by iterating over them
        for(int i=0; i<nums.length; i++) {
            // square the number
            nums[i] *= nums[i];
            
            // check if the previous number was greater than the current number.
            if( i != 0 && nums[i-1] > nums[i] ) {
                brkPoint = i;
            }
        }
        
        // If breakpoint is 0, that means there array is already sorted and we can return it.
        if( brkPoint == 0 ) {
            return nums;
        }
    
        // declare pointers for subarrays
        int i = brkPoint - 1, j = brkPoint, k = 0;
        int[] sorted = new int[nums.length];
        
        // Use merge sort technique to iterate over subarrays.
        // i will go from (brkPoint - 1) to 0 and j will go from brkPoint to arr.length
        while( i >= 0 && j < nums.length ) {
            
            // compare elements at pointers, whichever is lesser will be put into the sorted array
            if( nums[i] > nums[j] ) {
                sorted[k] = nums[j];
                j++;
            } else {
                sorted[k] = nums[i];
                i--;
            }
            k++;
        }
        
        // It might happen that after initial iteration one of the subarray get left with some elements.
        // Iterate over the subarray individually to put remaining numbers into the sorted array.
        while( j < nums.length ) {
            sorted[k] = nums[j];
            j++;
            k++;
        }
        
        while( i >= 0 ) {
            sorted[k] = nums[i];
            i--;
            k++;
        }
        
        return sorted;
    }
}
