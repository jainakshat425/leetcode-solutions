class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int minAllowed = 0;
        int moves = 0;
        
        Arrays.sort(nums);
        
        for(int i=0; i<n; i++) {
            if( nums[i] < minAllowed ) {
                moves += minAllowed - nums[i];
                nums[i] = minAllowed;
            } 
            minAllowed = nums[i] + 1;
        }
        return moves;
    }
}
