class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList();
        
        for(int i=0; i<numCourses; i++) {
            adj.add( new ArrayList() );
        }
        
        for(int[] reverseEdge : prerequisites) {
            adj.get(reverseEdge[1]).add(reverseEdge[0]);
        }
                
        boolean[] vis = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++) {

            if( !vis[i] && hasCycleDFS( i, adj, vis, new boolean[numCourses] ) ) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasCycleDFS(int vertex, List<List<Integer>> adj, boolean[] vis, boolean[] dfsVis) {
        vis[vertex] = true;
        dfsVis[vertex] = true;
        
        for(int adjV : adj.get(vertex)) {
            if( !vis[adjV] ) {
                if( hasCycleDFS(adjV, adj, vis, dfsVis) )  
                    return true;
            } else if( dfsVis[adjV] )
                return true;
        }
        
        dfsVis[vertex] = false;
        
        return false;
    }
    
}
