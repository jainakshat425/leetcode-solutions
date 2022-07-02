class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> count = new HashMap();
        int ans = 0;
        
        for(int num : nums)
            count.put(num, count.getOrDefault(num, 0) + 1);
        
        for(int num : count.keySet()) {
            if( k == 0 ) 
                ans += count.get(num) > 1 ? 1 : 0;
            
            else if( count.containsKey( num+k ) )
                ans++;
        }
        return ans;
    }
}
/* 
class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> seen = new HashSet();
        int ans = 0;
        
        Arrays.sort(nums);
        
        for(int i=0; i<n; i++) {
            
            if( seen.contains( nums[i] - k ) ) {
                ans++;
                seen.remove( nums[i] - k );
            }
            
            if( i == 0 || nums[i] != nums[i-1] )
                seen.add(nums[i]);
        }
        return ans;
    }
}
*/
