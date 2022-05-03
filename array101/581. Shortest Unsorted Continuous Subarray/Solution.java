class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length; 
        
        // Pointer to the first and the last index
        int left = 0, right = n-1;
        
        // Indices of current unsorted sub-array
        int start = -1, end = -1;
        
        // Minimum number till pointer right and maximum number till pointer left
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        // Repeat until right reaches 0 and left eventually reaches n-1
        while( right >= 0 ) {
            
            /* If current number {nums[left]} is lesser than {max} encountered till 
            left, then current number {nums[left]} is not in sorted position, */
            if( nums[left] < max ) {
                end = left;
            } else {
                // Else current number {nums[left]} is the {max} till left
                max = nums[left];
            }
            
            /* If current number {nums[right]} is greater than {min} encountered
            till right, then current number {nums[right]} is not in sorted position */
            if( nums[right] > min ) {
                start = right;
            } else {
                // Else current number {nums[right]} is the {min} till right
                min = nums[right];
            }
            
            left++;
            right--;
        }
        /* If any of the start or end is -1, then the array is sorted already, return 0.
         else return the size of the sub array */
        return start != -1 ? end-start+1 : 0;
    }
}
