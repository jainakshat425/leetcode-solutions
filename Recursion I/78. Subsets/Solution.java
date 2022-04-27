class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new LinkedList<>();
        // First subset will be an empty subset
        result.add( new LinkedList<>() );
        
        // Generate subset for each subset using current number
        for(int num : nums) {
            
            // Count the total subset in the result
            int size = result.size();
            
            // Generate subset for each subset using current number
            for(int i=0; i<size; i++) {
                
                // Clone current subset
                List<Integer> subset = new LinkedList<>( result.get(i) );
                // Add current number to it, to generate a new subset
                subset.add( num );
                
                // Add new subset to the result
                result.add( subset );
            }
        }
        return result;
    }
}
/*
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        
        subsets(nums, 0, new LinkedList<>(), result);
        
        return result;
    }
    
    private void subsets(int[] nums, int i, List<Integer> curr, List<List<Integer>> result) {
        if( i == nums.length ) {
            result.add( curr );
            return;
        }
        
        List<Integer> withNum = new LinkedList<>(curr);
        withNum.add( nums[i] );
        subsets(nums, i+1, withNum, result);
        
        List<Integer> withoutNum = new LinkedList<>(curr);
        subsets(nums, i+1, withoutNum, result);
    }
}
*/
