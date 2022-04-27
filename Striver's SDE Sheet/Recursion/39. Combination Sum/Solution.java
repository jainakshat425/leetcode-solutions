class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        
        combinationSum(candidates, target, 0, new LinkedList<>(), result);
        
        return result;
    }
    
    private void combinationSum(int[] candidates, int target, int index, List<Integer> subset, List<List<Integer>> result) {
        // Base case
        if( index == candidates.length ) {
            // If target reaches 0, then current subset is a valid combination
            if( target == 0 ) {
                result.add( new LinkedList<>( subset ) );
            }
            return;
        }
        
        /* Decision 1 - Pick current number if it's not greater than target 
        and can be part of combination */
        if( candidates[index] <= target ) {
            // Add the current number to the subset
            subset.add( candidates[index] );
            
            /* Call the function again by reducing the target while keeping 
            keeping the index (to check if current number can be picked again) */
            combinationSum(candidates, target - candidates[index], index, subset, result); 
            
            // Restore the original subset by removing the current number
            subset.remove( subset.size() - 1 );
        } 
        
        // Decision 2 - Do not pick current number 
        combinationSum(candidates, target, index+1, subset, result); 
    }
}
