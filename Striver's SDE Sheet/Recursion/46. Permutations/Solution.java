class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        permute(nums, 0, result);
        
        return result;
    }
    
    private void permute(int[] nums, int start, List<List<Integer>> result) {
        int n = nums.length;
        
        // All the permutations in the current path has been generated.
        if( start == n ) {
            result.add( new ArrayList<>( arrayToList( nums ) ));
            return;
        }
        
        for(int i=start; i<n; i++) {
            
            /* Swap the current number with the number at start to 
            generate next permutation */
            swap(nums, i, start);
            
            /* Fix the start, permute the number after start */
            permute(nums, start+1, result);
            
            /* Re-swap the current number with the number at start */
            swap(nums, i, start);
        }
    }
    
    private List<Integer> arrayToList(int[] arr) {
        List<Integer> lst = new ArrayList<>();
        for(int item : arr) {
            lst.add( item );
        }
        return lst;
    }
    
    private void swap(int[] arr, int i, int j) {
        if( i == j ) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
/*
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> candidates = new ArrayList<>();
        
        for(int num : nums) {
            candidates.add( num );
        }
        
        permute(candidates, new ArrayList<>(), result);
        
        return result;
    }
    
    private void permute(List<Integer> candidates, List<Integer> permutation, List<List<Integer>> result) {
        
        // Since no number is left for permutation, a permutation is generated
        if( candidates.isEmpty() ) {
            result.add( new ArrayList<>( permutation ) );
            return;
        }
        
        int n = candidates.size();
        
        for(int i=0; i<n; i++) {
            int num = candidates.get(i);
            
            // Fix the current number
            permutation.add( num );
            
            // Remove the current number from candidates
            candidates.remove( i );
            
            // And permute for remaining numbers
            permute(candidates, permutation, result);
            
            // Add the number back to it's original index
            candidates.add(i, num );
            
            // Remove the number from the permutation
            permutation.remove( permutation.size() - 1 );
        }
    }
}*/
