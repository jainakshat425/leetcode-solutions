class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return atmostKDistinct(nums, k) - atmostKDistinct(nums, k-1);
    }
    
    public int atmostKDistinct(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> countMap = new HashMap();
        int ans = 0;
        
        for(int r=0, l=0; r<n; r++) {
            countMap.put(nums[r], countMap.getOrDefault(nums[r], 0) + 1);
            
            while( countMap.size() > k ) {
                int leftCount = countMap.get(nums[l]) - 1;

                if( leftCount == 0 )
                    countMap.remove(nums[l]);
                else
                    countMap.put(nums[l], leftCount);
                l++;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
