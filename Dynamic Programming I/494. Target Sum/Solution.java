class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<String,Integer> dp = new HashMap();
        
        return findTargetSumWays(0, 0, target, nums, dp);
    }
    
    private int findTargetSumWays(int i, int total, int target, int[] nums, Map<String,Integer> dp) {
        if( i == nums.length )
            return total == target ? 1 : 0;

        String key = i + "_" + total;
        
        if( dp.containsKey(key) ) {
            return dp.get(key);
        }
        
        int add = findTargetSumWays(i+1, total+nums[i], target, nums, dp);
        int sub = findTargetSumWays(i+1, total-nums[i], target, nums, dp);
        
        dp.put(key, add + sub);
        
        return add+sub;
    }
}
