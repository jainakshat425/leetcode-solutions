class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int cols = n+1;
        int vertices = cols*cols;
        int ans = 0;
        DSU dsu = new DSU(vertices);
        
        for(int i=0; i<cols; i++) {
            dsu.union(0, i * cols);
            dsu.union(0, i * cols + n);
        }
        for(int j=0; j<cols; j++) {
            dsu.union(0, j);
            dsu.union(0, n * cols + j);
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                char c = grid[i].charAt(j);
                
                if( c == ' ' ) continue;
                
                int p1, p2;
                
                if( c == '/' ) {
                    p1 = (i+1) * cols + j;
                    p2 = i * cols + j+1;
                } else {
                    p1 = i * cols + j;
                    p2 = (i+1) * cols + j+1;
                }
                
                if( !dsu.union(p1, p2) )
                    ans++;
            }
        }
        return ans + 1;
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
    
    public int find(int x) {
        if( parent[x] != x )
            parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        
        if( xp == yp )
            return false;
        
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
