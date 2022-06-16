class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap();
        int count = 0;
        
        for(int num1 : nums1) {
            for(int num2 : nums2) {
                int sum = num1 + num2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
          
        for(int num3 : nums3) {
            for(int num4 : nums4) {
                int sum = -(num3 + num4);
                count += map.getOrDefault(sum, 0);
            }
        }
        return count;
    }
}
