class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = createAdjacencyList( numCourses, prerequisites );
                
        int[] indegree = calculateIndegree(numCourses, adj);
        
        Queue<Integer> queue = new LinkedList();
        
        int taken = 0;
        
        for(int i=0; i<numCourses; i++) {
            if( indegree[i] == 0 ) {
                queue.offer( i );
                taken++;
            }
        }
       
        while( !queue.isEmpty() ) {
            int vx = queue.poll();
            
            for(int adjV : adj.get(vx)) {
                indegree[adjV]--;
                
                if( indegree[adjV] == 0 ) {
                    queue.offer( adjV );
                    taken++;
                }
            }
        }
        
        return taken == numCourses;
    }
    
    private int[] calculateIndegree(int numCourses, List<List<Integer>> adj) {
        int[] indegree = new int[numCourses];
        
        for(List<Integer> adjacents : adj) {
            for(int adjV : adjacents)
                indegree[adjV]++;
        }
        
        return indegree;
    }
    
    private List<List<Integer>> createAdjacencyList(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList();
        
        for(int i=0; i<numCourses; i++) {
            adj.add( new ArrayList() );
        }
        
        for(int[] reverseEdge : prerequisites) {
            adj.get(reverseEdge[1]).add(reverseEdge[0]);
        }
        return adj;
    }
}
