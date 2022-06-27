class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {  
        int n = intervals.length;
        int q = queries.length;
        int[] ans = new int[q];
        
        // 0 > query, 1 > original index
        int[][] queryWithIndex = new int[q][2];
        
        for(int i=0; i<q; i++) 
            queryWithIndex[i] = new int[]{ queries[i], i };
        
        // Sort queries in asc order of their value
        Arrays.sort(queryWithIndex, (a,b) -> a[0] - b[0]);
        
        // Sort intervals in asc order of start value
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        // 0 > size, 1 > interval end
        PriorityQueue<int[]> pqueue = new PriorityQueue<int[]>(
            (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );
        
        // current interval index
        int i = 0;
        
        for(int[] query : queryWithIndex) {
            
            // Add all valid intervals for current query into the queue
            for(; i < n && intervals[i][0] <= query[0]; i++) {
                if( intervals[i][1] < query[0] )
                    continue;
                
                int size = intervals[i][1] - intervals[i][0] + 1;
                pqueue.offer(new int[]{ size, intervals[i][1] });
            }
            
            // Remove invalid intervals
            while( !pqueue.isEmpty() && pqueue.peek()[1] < query[0] )
                pqueue.poll();
            
            ans[query[1]] = pqueue.isEmpty() ? -1 : pqueue.peek()[0];
        }
        
        return ans;
    }
}
