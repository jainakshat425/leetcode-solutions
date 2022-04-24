class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        
        // To store traversed numbers with there index position
        Map<Integer,Integer> numberToIndexMap = new HashMap<>();
        
        // Iterate over each array index
        for(int i=0; i<n; i++) {
            
            // Find the difference between the target and the current number
            int diff = target - nums[i];
            
            // If difference exist in the map, return the index of difference and current number
            if( numberToIndexMap.containsKey( diff ) ) {
                return new int[]{ numberToIndexMap.get( diff ), i };
            } 
            
            // Put the current number and it's index into the map
            numberToIndexMap.put(nums[i], i);
        }
        
        return new int[]{-1, -1};
    }
}
