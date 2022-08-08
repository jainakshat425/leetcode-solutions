class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<Integer>[][] adj = new ArrayList[2][n];
        adj[0] = adjacenyFromEdges(n, redEdges);
        adj[1] = adjacenyFromEdges(n, blueEdges);
        
        int[][] dist = new int[2][n];
        Queue<int[]> queue = new LinkedList();
        
        for(int i=0; i<n; i++)
            dist[0][i] = dist[1][i] = Integer.MAX_VALUE;
        
        dist[0][0] = dist[1][0] = 0;
        queue.offer(new int[]{ 0, 0 });
        queue.offer(new int[]{ 0, 1 });
        
        while( !queue.isEmpty() ) {
            int u = queue.peek()[0];
            int c = queue.peek()[1];
            queue.poll();

            for(int v : adj[c][u]) {
                if( dist[c][u] + 1 >= dist[1-c][v] )
                    continue;

                dist[1-c][v] = dist[c][u] + 1;
                queue.offer(new int[]{ v, 1-c });
            }
        }
        
        int[] ans = new int[n];
        
        for(int i=1; i<n; i++) {
            int min = Math.min(dist[0][i], dist[1][i]);
            ans[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return ans;
    }
    
    private ArrayList<Integer>[] adjacenyFromEdges(int n, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        
        for(int i=0; i<n; i++)
            adj[i] = new ArrayList();
        
        for(int[] edge : edges) 
            adj[edge[0]].add( edge[1] );
        
        return adj;
    }
}
