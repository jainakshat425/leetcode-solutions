class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<int[]> queue = new LinkedList<int[]>();
        queue.offerLast(new int[]{nums[n-1], n-1});
        
        for(int i=n-2; i>=0; i--) {
            while( i + k < queue.peekFirst()[1] )
                queue.pollFirst();
            
            int curScore = nums[i] + queue.peekFirst()[0];
            
            while( !queue.isEmpty() && curScore >= queue.peekLast()[0] )
                queue.pollLast();
            
            queue.offer(new int[]{curScore, i});
        }
        return queue.peekLast()[0];
    }
}
// class Solution {
//     public int maxResult(int[] nums, int k) {
//         int n = nums.length;
//         PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(b[0], a[0]));
//         pq.offer(new int[]{nums[n-1], n-1});
        
//         for(int i=n-2; i>=0; i--) {
//             while( i + k < pq.peek()[1] )
//                 pq.poll();
//             pq.offer(new int[]{nums[i] + pq.peek()[0], i});
//         }
        
//         while( pq.peek()[1] != 0 )
//             pq.poll();
        
//         return pq.peek()[0];
//     }
// }
