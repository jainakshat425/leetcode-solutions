class Solution {
    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        int redundant = 0;
        
        for(int[] edge : connections) 
            if( !dsu.union(edge[0], edge[1]) )
                redundant++;
        
        int required = dsu.connected - 1;
        
        return redundant >= required ? required : -1;
    }
}
class DSU {
    private int[] parent;
    private int[] rank;
    public int connected;
    
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        connected = n;
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
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
        
        connected--;
        
        if( rank[xp] > rank[yp] ) 
            parent[yp] = xp;
        else if( rank[xp] < rank[yp] )
            parent[xp] = yp;
        else {
            parent[yp] = xp;
            rank[xp] += 1;
        }
        return true;
    }
}
