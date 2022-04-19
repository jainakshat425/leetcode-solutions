class Solution {
    public int maxSubArray(int[] nums) {
        /* 
        1. Kadane's Algorithm
        2. Initialize {sum} with 0 and {max} with 1st element, because subarray should contain atleast 1 element.
        3. Iterate over numbers in {nums}
            - Add current number {num} to {sum}
            - If current {sum} is greater than maximum sum {max}, update {max}.
            - If {sum} is less than 0, discard current subarray/sum by setting {sum} to 0.
        4. Return the {max}
        */
        
        // Initialize {sum} with 0 and {max} with 1st element, because subarray should contain atleast 1 element.
        int sum = 0;
        int max = nums[0];
        
        // Iterate over numbers in {nums}
        for(int num : nums) {
            
            // Add current number {num} to {sum}
            sum += num;
            
            // If current {sum} is greater than maximum sum {max}, update {max}.
            if( sum > max ) {
                max = sum;
            } 
            
            // If {sum} is less than 0, discard current subarray/sum by setting {sum} to 0.
            if( sum < 0 ) {
                sum = 0;
            }
        }
        return max;
    }
}
