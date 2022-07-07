class Solution {
    public int maximumProduct(int[] nums) {
        /* 
        If all number are positive -> max is product of three maximum nums
        If all number are negative -> max is product of three minimum nums
        If negative nums are there -> find max three nums, two minimum nums
        */
        int n = nums.length;
        
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        
        for(int num : nums) {
            if( num > max1 ) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } 
            else if( num > max2 ) {
                max3 = max2;
                max2 = num;
            }
            else if( num > max3 ) 
                max3 = num;
            
            if( num < min1 ) {
                min2 = min1;
                min1 = num;
            } 
            else if( num < min2 )
                min2 = num;
        }
        
        // covers all negative and all positve case
        int case1 = max1 * max2 * max3;
        // when two min values are have higher abs value than 2nd and 3rd max
        int case2 = max1 * min1 * min2;
        
        return Math.max(case1, case2);
    }
}
// class Solution {
//     public int maximumProduct(int[] nums) {
//         /* 
//         If all number are positive -> max is product of three maximum nums
//         If all number are negative -> max is product of three minimum nums
//         If negative nums are there -> find max three nums, two minimum nums
//         */
//         int n = nums.length;
//         Arrays.sort(nums);
        
//         int max1 = nums[n-1];
//         int max2 = nums[n-2];
//         int max3 = nums[n-3];
//         int min1 = nums[0];
//         int min2 = nums[1];
        
//         // covers all negative and all positve case
//         int case1 = max1 * max2 * max3;
//         // when two min values are have higher abs value than 2nd and 3rd max
//         int case2 = Math.max(case1, max1*min1*min2);
        
//         return Math.max(case1, case2);
//     }
// }
