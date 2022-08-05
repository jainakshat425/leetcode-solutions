class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int ans = 0;
        Deque<Integer> minDq = new LinkedList();
        Deque<Integer> maxDq = new LinkedList();
        
        for(int left=0, right=0; right<n; right++) {
            
            while( !minDq.isEmpty() && nums[minDq.peekLast()] > nums[right] )
                minDq.pollLast();
            
            while( !maxDq.isEmpty() && nums[maxDq.peekLast()] < nums[right] )
                maxDq.pollLast();
            
            minDq.offer(right);
            maxDq.offer(right);
            
            while( nums[maxDq.peekFirst()] - nums[minDq.peekFirst()] > limit ) {
                if( maxDq.peekFirst() <= left )
                    maxDq.pollFirst();
                if( minDq.peekFirst() <= left )
                    minDq.pollFirst();
                left++;
            }
            
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
// class Solution {
//     public int longestSubarray(int[] nums, int limit) {
//         int n = nums.length;
//         int ans = 0;
//         TreeMap<Integer,Integer> seenCount = new TreeMap();
        
//         for(int left=0, right=0; right<n; right++) {
            
//             int rightCnt = seenCount.getOrDefault(nums[right], 0) + 1;
//             seenCount.put(nums[right], rightCnt);
            
//             while( seenCount.lastKey() - seenCount.firstKey() > limit ) {
//                 int leftCnt = seenCount.get(nums[left]) - 1;
                
//                 if( leftCnt == 0 ) 
//                     seenCount.remove(nums[left]);
//                 else 
//                     seenCount.put(nums[left], leftCnt);
                
//                 left++;
//             }
            
//             ans = Math.max(ans, right-left+1);
//         }
//         return ans;
//     }
// }
