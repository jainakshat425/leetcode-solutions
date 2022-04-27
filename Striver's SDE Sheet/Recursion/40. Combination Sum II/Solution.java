class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        // Sort the candidates as this will help in avoiding duplicate subsets
        Arrays.sort( candidates );
        
        List<List<Integer>> result = new LinkedList<>();
        
        /* Call {combinationSum2} recursively for 0th level -> 1st Level -> 2nd Level -> ...
        At each level we will generate subset of level size. For eg. for 1st level we have to 
        generate all subsets of size 1, for 2nd level generate all subsets of size 2 and so on.
        While including each number in a subset, subtract it from the target till the target 
        reaches 0. */
        combinationSum2(candidates, target, 0, new LinkedList<>(), result);
        
        return result;
    }
    
    private void combinationSum2(int[] candidates, int target, int start, List<Integer> subset, List<List<Integer>> result) {
        
        /* If target has reached 0, current subset is a valid combination,
        add it to the result and backtrack */
        if( target == 0 ) {
            result.add( new LinkedList<>( subset ));
            return;
        }
        
        /* If current chain has ended and the target is still not 0
        then no valid subset is present in this path and hence backtrack */
        if( start == candidates.length ) {
            return;
        }
        
        // Generate subsets for current level
        for(int i = start; i < candidates.length; i++) {
            
            /* If current number is greater than target and since numbers are sorted,
            no need to generate subset from here as it will exceed the target */
            if( candidates[i] > target ) {
                break;
            }
            
            /* If current no. is same as previous number, skip current number to 
            avoid duplicate subsets */
            if( i != start && candidates[i] == candidates[i-1] ) {
                continue;
            }
            
            // Include current number in the subset and subtract it from the target
            subset.add( candidates[i] );
            combinationSum2(candidates, target - candidates[i], i+1, subset, result);
            
            /* Remove the current number from subset after all the subsets from 
            current number has been generated */
            subset.remove( subset.size() - 1 );
        }
    }
}
