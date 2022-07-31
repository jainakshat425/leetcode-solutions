class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        // stores the index of incoming edge 
        int[] indegree = new int[n+1];
        // index of edges pointing to the same vertex
        int red1 = -1, red2 = -1;
        DSU dsu = new DSU(n+1);
        int cycleFound = -1;
        Arrays.fill(indegree, -1);
        
        for(int i=0; i<n; i++) {
            int u = edges[i][0], v = edges[i][1];
            
            if( indegree[v] != -1 ) {
                red1 = indegree[v];
                red2 = i;
            }
            indegree[v] = i; 
            
            if( !dsu.union(u, v) )
                cycleFound = i;
        }
        
        // case 1: indegree of all the vertices is 1 (only cycle)
        // return the last edge which is creating cycle
        if( red1 == -1 )
            return edges[cycleFound];
        
        // case 2: indegree of a vertex is 2, but there is no cycle
        // return the second edge with the same adjacent edge
        if( cycleFound == -1 )
            return edges[red2];
        
        // case 3: indegree of a vertex is 2 and there is a cycle
        // again run cycle detection aglo by excluding one of the two redundant 
        // edge, if no cycle is detected, excluded edge is redundant, else
        // the other edge is redundant
        dsu = new DSU(n+1);
        
        for(int i=0; i<n; i++) {
            if( i == red2 ) continue;
            
            int u = edges[i][0], v = edges[i][1];
            
            if( !dsu.union(u, v) )
                return edges[red1];
        }
        return edges[red2];
    }
}
class DSU {
    private int[] parent;
    private int[] rank;
    
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0; i<n; i++)
            parent[i] = i;
    }
        
    public int find(int x) {
        if( parent[x] != x ) 
            parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        
        if( xp == yp ) return false;
        
        if( rank[xp] > rank[yp] )
            parent[yp] = xp;
        else if( rank[yp] > rank[xp] )
            parent[xp] = yp;
        else {
            parent[yp] = xp;
            rank[xp] += 1;
        }
        return true;
    }
}
