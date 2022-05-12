class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList();
        permuteUnique(nums, n, 0, ans);
        return ans;
    }
    
    private void permuteUnique(int[] nums, int n, int start, List<List<Integer>> ans) {
        
        if(start == n) {
            ans.add( arrayToList(nums) );
            return;
        }
        
        Set<Integer> used = new HashSet();
        
        for(int i=start; i<n; i++) {
            
            if( used.contains( nums[i] )  )
                continue;
            
            used.add( nums[i] );
            
            swap(nums, i, start);
            
            permuteUnique(nums, n, start+1, ans);
            
            swap(nums, i, start);
        }
    }
    
    private List<Integer> arrayToList(int[] arr) {
        List<Integer> lst = new ArrayList();
        for(int item : arr)
            lst.add( item );
        return lst;
    }
                      
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
