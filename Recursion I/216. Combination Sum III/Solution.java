class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList();
        combinationSum3(k, n, 1, new ArrayList(), ans);
        return ans;
    }
    
    private void combinationSum3(int k, int target, int start, List<Integer> comb, List<List<Integer>> ans) {
        // If k numbers are added, and target is 0, add current combination to answer
        if( nums.size() == k ) {
            if( target == 0 ) 
                ans.add( new ArrayList(comb) );
            return;
        }
        
        /* Iterate for each number from start to 9 and number should not be greater 
        than target */
        for(int num=start; num <= target && num<=9; num++) {
            
            // Add current number to combination/Fix current number
            comb.add(num);
            
            // Try other numbers to complete the current combination
            combinationSum3(k, target-num, num+1, comb, ans);
            
            // Backtrack: Remove the current num, and generate combination for next numbers.
            comb.remove( comb.size()-1 );
        }
    }
}
