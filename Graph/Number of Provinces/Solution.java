class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        
        for(int i=0; i<n; i++) 
            for(int j=i+1; j<n; j++) 
                if( isConnected[i][j] == 1 )
                    dsu.union(i,j);
            
        return dsu.getCount();
    }
}
class DSU {
    private int[] parent;
    private int[] rank;
    private int count;
    
    public DSU(int n) {
        count = n;
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
        count--;
        
        return true;
    }
    
    public int getCount() {
        return count;
    }
}
