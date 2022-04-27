class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        // Sort the numbers as it will help in eliminating duplicates.
        Arrays.sort(nums);
        
        // Declare a list hold the result
        List<List<Integer>> result = new LinkedList<>();
           
        // Call recursive function {subsets} to generate subsets
        subsets(nums, 0, new LinkedList<>(), result);
            
        return result;
    }
    
    private void subsets(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add( subset );
        
        // Base case
        if( start == nums.length ) return;
        
        // Generate subsets for current subset
        for(int i=start; i<nums.length; i++) {
            
            // Skip current number if it's duplicate of previous number
            if( i != start && nums[i-1] == nums[i] ) {
                continue;
            }
            
            /* Generate a new subset from current subset by adding 
            current number to the list */
            List<Integer> newSubset = new LinkedList<>( subset );
            newSubset.add( nums[i] );
            
            // Generate subsets recursively for this newly created subset
            subsets(nums, i+1, newSubset, result);
        }
    }
}


/*
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Set<List<Integer>> resultSet = new HashSet<>();
        // First subset will be an empty subset
        resultSet.add( new LinkedList<>() );
        
        // Generate subset for each subset using current number
        for(int num : nums) {
            
            Set<List<Integer>> newSubsets = new HashSet<>();
            
            // Generate subset for each subset using current number
            for(List<Integer> subset : resultSet) {
                
                // Clone current subset
                List<Integer> newSubset = new LinkedList<>( subset );
                // Add current number to it, to generate a new subset
                newSubset.add( num );
                
                // Add new subset to the result
                newSubsets.add( newSubset );
            }
            
            for(List<Integer> subset : newSubsets) {
                // Add new subset to the result
                resultSet.add( subset );
            }
        }
        
        List<List<Integer>> result = new LinkedList<>();
        
        for(List<Integer> list : resultSet) {
            result.add( list );
        }
        
        return result;
    }
}*/
