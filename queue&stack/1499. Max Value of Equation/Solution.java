class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> dq = new ArrayDeque();
        int ans = Integer.MIN_VALUE;
        
        for(int[] p : points) {
            int xj = p[0];
            int yj = p[1];
            
            while( !dq.isEmpty() && xj - dq.peekFirst()[1] > k )
                dq.pollFirst();
            
            if( !dq.isEmpty() )
                ans = Math.max(ans, xj + yj + dq.peekFirst()[0]);
            
            while( !dq.isEmpty() && dq.peekLast()[0] < (yj - xj) )
                dq.pollLast();
            
            dq.offerLast(new int[]{yj-xj, xj});
        }
        return ans;
    }
}
// class Solution {
//     public int findMaxValueOfEquation(int[][] points, int k) {
//         PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> 
//                                                            a[0] == b[0] ? 
//                                                            Integer.compare(a[1],b[1]) :
//                                                            Integer.compare(b[0],a[0]));
//         int ans = Integer.MIN_VALUE;
        
//         for(int[] p : points) {
//             int xj = p[0];
//             int yj = p[1];
            
//             while( !pq.isEmpty() && xj - pq.peek()[1] > k )
//                 pq.poll();
            
//             if( !pq.isEmpty() )
//                 ans = Math.max(ans, xj + yj + pq.peek()[0]);
            
//             pq.offer(new int[]{yj-xj, xj});
//         }
//         return ans;
//     }
// }
