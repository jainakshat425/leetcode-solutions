class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
           
        // Since the graph can be disconnected, try coloring each vertex
        for(int i=0; i<n; i++) {
            // Current vertex is already colored
            if( color[i] != 0 )
                continue;
            
            // Color current vertex with 1
            Queue<Integer> queue = new LinkedList();
            queue.offer( i );
            color[i] = 1;
            
            // Repeat for adjacent vertices, assign them inverse color (-1)
            while( !queue.isEmpty() ) {
                int u = queue.poll();
                
                for(int v : graph[u]) {
                    
                    // Adjacent vertex is not colored/visited, color it with inverse color
                    if( color[v] == 0 ) {
                        color[v] = -color[u];
                        queue.offer( v );
                    }
                    // Adjacent vertex is already colored with same color
                    else if( color[v] == color[u] )
                        return false;
                }
            }
        }
        return true;
    }
}
