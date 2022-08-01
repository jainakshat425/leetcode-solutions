class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Integer> seen = new TreeSet();
        seen.add( nums[0] );
        
        for(int j=1; j<n; j++) {
            if( j > k ) seen.remove( nums[j - k - 1] );
            
            Integer ceil = seen.ceiling(nums[j]);
            if( ceil != null && Math.abs((long)ceil - nums[j]) <= t ) return true;
            
            Integer floor = seen.floor(nums[j]);
            if( floor != null && Math.abs((long)floor - nums[j]) <= t ) return true;
            
            seen.add( nums[j] );
        }
        return false;
    }
}
