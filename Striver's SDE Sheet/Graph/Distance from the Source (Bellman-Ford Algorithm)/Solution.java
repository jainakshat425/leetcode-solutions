/*
*   adj: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000);
        dist[S] = 0;
        
        // Relax V-1 times
        for(int i=1; i<V; i++) {
            boolean relaxed = false;
            
            for(ArrayList<Integer> edge : adj) {
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                
                if( dist[u]+w < dist[v] ) {
                    dist[v] = dist[u]+w;
                    relaxed = true;
                }
            }
            // Break if further relaxasation is not possible
            if( !relaxed )
                break;
        }
        return dist;
    }
}

