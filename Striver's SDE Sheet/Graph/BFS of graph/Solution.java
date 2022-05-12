class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean[] vis = new boolean[V];
        Queue<Integer> queue = new LinkedList();
        queue.offer( 0 );
        vis[0] = true;
        
        while( !queue.isEmpty() ) {
            Integer curr = queue.poll();
            ans.add(curr);
            
            for(int adjV : adj.get(curr)) {
                if( !vis[adjV] ) {
                    queue.offer( adjV );
                    vis[adjV] = true;
                }
            }
        }
        return ans;
    }
}
