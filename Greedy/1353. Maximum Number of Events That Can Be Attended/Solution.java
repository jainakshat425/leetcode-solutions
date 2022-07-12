class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        int ans = 0;
        // Sort in asc order of start time 
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));
        
        // End times sorted in asc order
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        int i = 0, day = 0;
        
        while( i < n || !pq.isEmpty() ) {
            
            if( pq.isEmpty() )
                day = events[i][0];
            
            while( i < n && events[i][0] == day )
                pq.offer( events[i++][1] );
            
            pq.poll();
            ans++;
            day++;
            
            while( !pq.isEmpty() && pq.peek() < day )
                pq.poll();
        }
        return ans;
    }
}
