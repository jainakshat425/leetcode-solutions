class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dist = new int[V];
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue(new ArrayListComparator());
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        queue.offer( new ArrayList(){{ add(S); add(0); }} );
        
        while( !queue.isEmpty() ) {
            int u = queue.peek().get(0);
            int uw = queue.peek().get(1);
            queue.poll();
            
            if( uw > dist[u] )
                continue;
                
            for(ArrayList<Integer> adjV : adj.get(u)) {
                int v = adjV.get(0);
                int vw = adjV.get(1);
                
                int distance = uw + vw;
                
                if( distance < dist[v] ) {
                    dist[v] = distance;
                    adjV.set(1, distance);
                    queue.offer( adjV );
                }
            }
        }
        return dist;
    }
    
    static class ArrayListComparator implements Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
            return arr1.get(1) - arr2.get(1);
        }
    }
}

