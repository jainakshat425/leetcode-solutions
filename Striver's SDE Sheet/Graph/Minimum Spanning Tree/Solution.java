class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        boolean[] mst = new boolean[V];
        int[] key = new int[V];
        int sum = 0;
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<ArrayList<Integer>>(
            (arr1,arr2) -> arr1.get(1) - arr2.get(1)
        );
        
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        queue.offer( createNode(0, 0) );
        
        while( !queue.isEmpty() ) {
            int u = queue.peek().get(0);
            queue.poll();
            mst[u] = true;
            
            for(ArrayList<Integer> adjNode : adj.get(u)) {
                int v = adjNode.get(0);
                int w = adjNode.get(1);
                
                if( !mst[v] && w < key[v] ) {
                    key[v] = w;
                    queue.offer( adjNode );
                }
            }
        }
        
        for(int w : key) {
            sum += w;
        }
        
        return sum;
    }
    
    private static ArrayList<Integer> createNode(int v, int w) {
        return new ArrayList<Integer>() {{ add(v); add(w); }};
    }
}
