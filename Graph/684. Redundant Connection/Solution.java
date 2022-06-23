class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n+1);
        
        for(int[] edge : edges) {
            if( !dsu.union(edge[0], edge[1]) )
                return edge;
        }
            
        return new int[]{ -1, -1 };
    }
}
class DSU {
    private int[] parent;
    private int[] rank;
    
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int node) {
        if( parent[node] != node )
            parent[node] = find(parent[node]);
        return parent[node];
    }
    
    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        if( p1 == p2 )
            return false;
        
        if( rank[p1] > rank[p2] ) 
            parent[p2] = p1;
        else if( rank[p2] > rank[p1] ) 
            parent[p1] = p2;
        else {
            parent[p2] = p1;
            rank[p1] += 1;
        }
        return true;
    }
}
/*
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        
        for(int i=0; i<=n; i++) 
            adj.add(new ArrayList());
        
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> redundant = new HashSet();
        dfs(1, -1, new int[]{ 1 }, new int[n+1], adj, redundant);
        
        for(int i=n-1; i>=0; i--) {
            int key = hash(edges[i][0], edges[i][1]);
            
            if( redundant.contains( key ) ) 
                return edges[i];
        }
        return new int[]{-1, -1};
    }
    
    private void dfs(int u, int par, int[] timer, int[] vis, 
                     ArrayList<ArrayList<Integer>> adj, 
                     Set<Integer> redundant) {
        vis[u] = timer[0];
        timer[0] += 1;
        
        for(int v : adj.get(u)) {
            if( v == par )
                continue;
            
            if( vis[v] == 0 ) 
                dfs(v, u, timer, vis, adj, redundant);
            
            if( vis[v] < vis[u] ) {
                vis[u] = vis[v];
                redundant.add( hash(u, v) );
            }
        }
    }
    
    private int hash(int a, int b) {
        return a*a + b*b;
    }
}
*/
