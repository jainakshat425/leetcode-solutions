class Solution {
    public int pivotIndex(int[] nums) {
        
        /* 
        1. Store sum of all the numbers of the array in a variable {sum}.
        2. Iterate over numbers {nums}
            - Calculate sum of all the numbers right to the current element using formula {sum - leftSum - nums[i]}.
            - If leftSum and rightSum match, return current index {i}
            - else, add current number to leftSum.
        */
        
        if( nums == null || nums.length == 0 ) {
            return -1;
        } else if( nums.length == 1 ) {
            return 0;
        }
        
        int sum = 0;
        
        // Store sum of all the numbers of the array in a variable {sum}.
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        
        int leftSum = 0, rightSum;

        // Iterate over numbers {nums}
        for(int i=0; i<nums.length; i++) {
            
            // Calculate sum of all the numbers right to the current element 
            // using formula {sum - leftSum - nums[i]}
            rightSum = sum - leftSum - nums[i];
            
            // If leftSum and rightSum match, return current index {i}
            if( leftSum == rightSum ) {
                return i;
            } else {
                
                // add current number to leftSum.
                leftSum += nums[i];
            }
        }
        
        return -1;
    }
}
