class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Node>> adj = createAdjacenyList(times, n);
        int[] dist = new int[n+1];
        PriorityQueue<Node> queue = new PriorityQueue();
        
        Arrays.fill( dist, Integer.MAX_VALUE );
        dist[k] = 0;
        queue.offer( new Node(k, 0) );
        
        while( !queue.isEmpty() ) {
            int u = queue.peek().v;
            int w = queue.peek().weight;
            queue.poll();
            
            if( w > dist[u] )
                continue;
            
            for(Node node : adj.get(u)) {
                int distance = w + node.weight;
                
                if( distance < dist[node.v] ) {
                    node.weight = dist[node.v] = distance;
                    queue.offer( node );
                }
            }
        }
        
        int max = 0;
        for(int i=1; i<=n; i++) {
            if( dist[i] == Integer.MAX_VALUE )
                return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
    
    private ArrayList<ArrayList<Node>> createAdjacenyList(int[][] times, int n) {
        ArrayList<ArrayList<Node>> adj = new ArrayList();
        
        for(int i=0; i<=n; i++) 
            adj.add( new ArrayList() );
        
        for(int[] edge : times) {
            adj.get( edge[0] ).add( new Node(edge[1], edge[2]) );
        }
        return adj;
    }
    
    class Node implements Comparable<Node> {
        public int v;
        public int weight;
        
        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node node2) {
            return this.weight - node2.weight;
        }
    }
}
