class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int ans = 0;
        int reachable = startFuel;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        for(int[] station : stations) {
            while( !pq.isEmpty() && reachable < station[0] ) {
                reachable += pq.poll();
                ans++;
                
                if( reachable >= target )
                    return ans;
            }
            
            if( reachable < station[0] )
                return -1;
            
            pq.offer(station[1]);
        }
        
        while( !pq.isEmpty() && reachable < target ) {
            reachable += pq.poll();
            ans++;
        }
        
        return reachable >= target ? ans : -1;
    }
}
