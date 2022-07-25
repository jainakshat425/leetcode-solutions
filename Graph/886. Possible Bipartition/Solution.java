class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] adjacency = new ArrayList[n+1];
        int[] color = new int[n+1];
        
        for(int i=1; i<n+1; i++) 
            adjacency[i] = new ArrayList();
        
        for(int[] edge : dislikes) {
            adjacency[edge[0]].add(edge[1]);
            adjacency[edge[1]].add(edge[0]);
        }
        
        for(int i=1; i<n+1; i++) {
            if( color[i] != 0 )
                continue;
            
            Queue<Integer> queue = new LinkedList();
            queue.offer(i);
            color[i] = 1;
            
            while( !queue.isEmpty() ) {
                int u = queue.poll();
                
                for(int v : adjacency[u]) {
                    if( color[v] == 0 ) {
                        color[v] = -color[u];
                        queue.offer(v);
                    } else if( color[v] == color[u] )
                        return false;
                }
            }
        }
        return true;
    }
}
