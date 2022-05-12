class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList();
        /* Since the graph is undirected and connected, no need to loop through 
        each vertex, it'll anyway reach all the vertices through DFS */
        dfs(0, visited, ans, adj);
        return ans;
    }
    
    private void dfs(int vertex, boolean[] visited, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj) {
        visited[vertex] = true;
        ans.add( vertex );
        
        for(int adjV : adj.get(vertex)) {
            if( !visited[adjV] )
                dfs(adjV, visited, ans, adj);
        }
    }
}
