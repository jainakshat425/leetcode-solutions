class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        /* 
        1. Two Pointer and Sliding Window Approach.
        2. Declare 
            - {left} and {right} - pointer to the start and end of the subarray, initialized to 0.
            - {sum} - sum of the elements of subarray, initialized to 0.
            - {min} - length of min subarray having {sum} greater than {target}, initialized to integer max.
        3. Keep moving {right} pointer until {sum} is greater than equals to the {target}, adding values under {right} pointer to the {sum}.
            - Keep moving {left} pointer until {sum} is greater than equals to the {target}, subtracting values under {left} pointer to the {sum}.
                - Calculate minimum of {min} and current subarray {right-left+1}
        */
        
        // pointer to the start and end of the subarray, initialized to 0.
        int left = 0, right = 0;
         // sum of the elements of subarray, initialized to 0.
        int sum = 0;
        // length of min subarray having {sum} greater than {target}, initialized to integer 
        int min = Integer.MAX_VALUE;
        
        // Keep moving {right} pointer until {sum} is greater than equals to the {target}, adding values under {right} pointer to the {sum}.
        while( right < nums.length ) {
            
            sum += nums[right];
            
            // Keep moving {left} pointer until {sum} is greater than equals to the {target}, subtracting values under {left} pointer to the {sum}.
            while( sum >= target ) {
                
                // Calculate minimum of {min} and current subarray {right-left+1}
                min = Math.min( min, (right-left+1) );
                
                sum -= nums[left++];                
            }
            
            ++right;
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
