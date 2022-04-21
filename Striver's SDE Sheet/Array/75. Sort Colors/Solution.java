class Solution {
    public void sortColors(int[] nums) {
        
        // Left points to the index where next 0 has to placed (leftmost non-zero position)
        int left = 0;
        // Left points to the index where next 2 has to placed (rightmost non-two position)
        int right = nums.length-1;
        
        int curr = 0;
        
        while( curr <= right ) {
            
            // If current number is 0, swap it with the leftmost non-zero position
            if( nums[curr] == 0 ) {
                swap(nums, curr, left);
                
                // Move left and current pointer forward
                left++;
                curr++;
            }
            // If current number is 2, swap it with the rightmost non-two position
            else if( nums[curr] == 2 ) {
                swap(nums, curr, right);
                // Move right backward 
                right--;
            } 
            else {
                // Move to the next index
                curr++;
            }            
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
