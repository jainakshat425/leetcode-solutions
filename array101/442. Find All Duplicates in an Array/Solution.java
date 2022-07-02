class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList();

        for(int num : nums) {
            num = Math.abs(num);
            
            if( nums[num-1] < 0 )
                ans.add(num);
            else
                nums[num-1] *= -1;
        }
        return ans;
    }
}
