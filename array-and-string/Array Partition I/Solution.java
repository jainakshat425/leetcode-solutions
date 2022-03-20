class Solution {
    public int arrayPairSum(int[] nums) {
        /* 
        1. Sort the number in ASC order.
        2. Loop through the numbers {num} and add them to {sum}, skipping every second number.
        */
        
        // Sort the number in ASC order.
        Arrays.sort(nums);
        
        // [6,2,6,5,1,2]
        // [1, 2, 2, 5, 6, 6]
        //  1     2     6
        int sum = 0;
        
        // Loop through the numbers {num} and add them to {sum}, skipping every second number.
        for(int i=0; i<nums.length; i = i+2) {
            sum += nums[i];
        }
        
        return sum;
    }
}
