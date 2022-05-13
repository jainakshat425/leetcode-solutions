class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] ans = new int[V];
        int[] index = new int[]{ V-1 };
        boolean[] vis = new boolean[V];
        
        for(int i=0; i<V; i++) {
            if( !vis[i] )
                dfs(i, adj, vis, ans, index);
        }
        
        return ans;
    }
    
    static void dfs(int vertex, ArrayList<ArrayList<Integer>> adj, 
        boolean[] vis, int[] ans, int[] index) {
        vis[vertex] = true;
        
        for(int adjV : adj.get(vertex)) {
            if( !vis[adjV] )
                dfs(adjV, adj, vis, ans, index);
        }
        
        ans[index[0]] = vertex;
        --index[0];
    }
}
