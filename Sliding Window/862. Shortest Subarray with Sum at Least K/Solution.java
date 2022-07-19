class Solution {
    
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        Deque<Pair<Long,Integer>> dq = new LinkedList();
        long runningSum = 0;
        int ans = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++) {
            runningSum += nums[i];
            
            if( runningSum >= k )
                ans = Math.min(ans, i+1);
            
            while( !dq.isEmpty() && runningSum - dq.peekFirst().getKey() >= k ) 
                ans = Math.min(ans, i - dq.pollFirst().getValue());
            
            while( !dq.isEmpty() && dq.peekLast().getKey() >= runningSum )
                dq.pollLast();
            
            dq.offerLast(new Pair( runningSum, i ) );
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}
// class Solution {
//     public int shortestSubarray(int[] nums, int k) {
//         int n = nums.length;
//         TreeMap<Long,Integer> preSum = new TreeMap(){{ put(0l, -1); }};
//         long runningSum = 0;
//         int ans = Integer.MAX_VALUE;
        
//         for(int i=0; i<n; i++) {
//             if( nums[i] >= k )
//                 return 1;
            
//             runningSum += nums[i];

//             Long sum = preSum.floorKey( runningSum - k );
            
//             if( sum != null ) {
//                 System.out.println(sum);
//                 ans = Math.min(ans, i - preSum.get(sum));
//             }
                
//             while( !preSum.isEmpty() && runningSum <= preSum.lastKey() )
//                 preSum.remove( preSum.lastKey() );
            
//             preSum.put(runningSum, i);
//         }
//         return ans != Integer.MAX_VALUE ? ans : -1;
//     }
// }
