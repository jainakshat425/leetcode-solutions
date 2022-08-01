class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> seen = new HashSet();
        
        for(int i=0; i<n; i++) {
            if( i > k ) seen.remove(nums[i-k-1]);
            if( !seen.add(nums[i]) ) return true;
        }
        return false;
    }
}
// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         int n = nums.length;
//         Map<Integer,Integer> seen = new HashMap();
        
//         for(int i=0; i<n; i++) {
//             if( seen.containsKey(nums[i]) ) 
//                 if( i - seen.get(nums[i]) <= k ) 
//                     return true;
//             seen.put(nums[i], i);
//         }
//         return false;
//     }
// }
