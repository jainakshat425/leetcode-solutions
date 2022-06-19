class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        int k = 3;
        kSum(0, 0, k, nums, new ArrayList(k), ans);
        return ans;
    }
    
    private void kSum(int start, int sum, int k, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        
        if( k == 2 ) {
            twoSum(start, -sum, nums, curr, ans);
            return;
        }
        
        int n = nums.length;
        
        for(int i=start; i<n; i++) {
            if( i != start && nums[i] == nums[i-1])
                continue;
            
            sum += nums[i];
            curr.add( nums[i] );
            kSum(i+1, sum, k-1, nums, curr, ans);
            sum -= nums[i];
            curr.remove( curr.size()-1 );
        }
    }
    
    private void twoSum(int start, int target, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        
        int n = nums.length;
        int left = start, right = n - 1;
        while( left < right ) {

            if( left != start && nums[left] == nums[left-1] ) {
                left++;
                continue;
            }
            if( right != n-1 && nums[right] == nums[right+1] ) {
                right--;
                continue;
            }
            
            int sum = nums[left] + nums[right];

            if( sum == target ) {
                
                List<Integer> temp = new ArrayList(curr);
                temp.add( nums[left] );
                temp.add( nums[right] );
                ans.add(temp);
                
                left++;
                right--;
            } 
            else if( sum < target ) 
                left++;
            else
                right--;
        }
    }
}
