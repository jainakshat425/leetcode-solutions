class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        
        for(int[] row : dist) 
            Arrays.fill(row, Integer.MAX_VALUE);
        
        for(int[] e : edges) 
            dist[e[0]][e[1]] = dist[e[1]][e[0]] = e[2];
        
        for(int via=0; via<n; via++) {
            for(int u=0; u<n; u++) {
                for(int v=u+1; v<n; v++) {
                    if( dist[u][via] == Integer.MAX_VALUE || 
                       dist[via][v] == Integer.MAX_VALUE )
                        continue;
                    
                    dist[u][v] = dist[v][u] = Math.min(dist[u][v], dist[u][via] + dist[via][v]);
                }
            }
        }
        int city = -1, min = n;
        
        for(int u=0; u<n; u++) {
            int reachable = 0;
            for(int v=0; v<n; v++) {
                if( dist[u][v] <= distanceThreshold )
                    reachable++;
            }
            if( reachable <= min ) {
                min = reachable;
                city = u;
            }
        }
        return city;
    }
}
