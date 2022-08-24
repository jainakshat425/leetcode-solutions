class Solution {
    public int countPaths(int n, int[][] roads) {
        int dest = n-1, max = 1000000007;
        ArrayList<int[]>[] adj = createAdj(n, roads);
        long[] dist = new long[n];
        int[] ways = new int[n];
        
        Arrays.fill(dist, Long.MAX_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> Long.compare(a.d,b.d));
        pq.offer(new Pair(0,0l));
        dist[0] = 0l;
        ways[0] = 1;
        
        while( !pq.isEmpty() ) {
            int u = pq.peek().v;
            long d = pq.peek().d;
            pq.poll();
            
            if( d > dist[u] ) 
                continue;
            
            for(int[] nei : adj[u]) {
                int v = nei[0];
                long newDist = d + nei[1];
                
                // pruning
                if( newDist > dist[dest] )
                    continue;
                
                if( newDist == dist[v] )
                    ways[v] = (ways[v] + ways[u]) % max;
                
                else if( newDist < dist[v] ) {
                    ways[v] = ways[u];
                    dist[v] = newDist;
                    pq.offer(new Pair(v, newDist));
                }
            }
        }
        return ways[dest];
    }

    private ArrayList<int[]>[] createAdj(int n, int[][] edges) {
        ArrayList<int[]>[] adj = new ArrayList[n];
        
        for(int i=0; i<n; i++)
            adj[i] = new ArrayList();
        
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], d = edge[2];
            
            adj[u].add(new int[]{v, d});
            adj[v].add(new int[]{u, d});
        }       
        return adj;
    }
    
    public class Pair {
        public int v;
        public long d;
        
        public Pair(int v, long d) {
            this.v = v;
            this.d = d;
        }
    }
}
