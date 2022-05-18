class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Prepare the adjaceny list from the given edges 
        ArrayList<ArrayList<Integer>> adjList = createAdjacenyList(n, connections);
        
        // Stores critical edges
        List<List<Integer>> ans = new ArrayList();
        
        // Stores discovery time and minimum discovery time of each node in the graph
        int[] dis = new int[n];
        int[] minDis = new int[n];
        
        // Running timer, starts from 1.
        int[] timer = new int[] { 1 };
        
        // DFS from 0th node, since there is no parent, set parent to -1.
        dfs(0, -1, adjList, dis, minDis, timer, ans);
        
        return ans;
    }
    
    private ArrayList<ArrayList<Integer>> createAdjacenyList(int n, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList();
        
        for(int i=0; i<n; i++)
            adjList.add( new ArrayList() );
        
        for(List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get( u ).add( v );
            adjList.get( v ).add( u );
        }
        
        return adjList;
    }
    
    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adjList, int[] dis, int[] minDis, 
                     int[] timer, List<List<Integer>> ans) {

        // Set minimum discovery time and discovery time to current time
        minDis[node] = dis[node] = timer[0]++;
        
        for(int adj : adjList.get(node)) {
            // Skip if the adjacent node is the parent
            if( adj == parent ) 
                continue;
            
            // If adjacent node is not yet visited, DFS on the adjacent node
            if( dis[adj] == 0 ) 
                dfs(adj, node, adjList, dis, minDis, timer, ans);
            
            /* If adjacent node can be discovered early than the current node, 
            than update the minimum discovery time of current node as well */
            minDis[node] = Math.min(minDis[node], minDis[adj]);
        }
        
        /* If current node can only be disovered from the parent node, than the
        parent to current node's edge is critical edge (bridge) */
        if( parent != -1 && minDis[node] > dis[parent] ) 
            ans.add( new ArrayList() {{ add(parent); add(node); }});
    }
}
