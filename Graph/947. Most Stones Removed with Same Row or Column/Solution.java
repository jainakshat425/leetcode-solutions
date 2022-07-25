class Solution {
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU(stones);
        
        for(int[] stone : stones) 
            dsu.union(~stone[0], stone[1]);
        
        return stones.length - dsu.groups;
    }
}
class DSU {
    private Map<Integer,Integer> parent, rank;
    public int groups;
    
    public DSU(int[][] stones) {
        parent = new HashMap();
        rank = new HashMap();
        
        for(int[] stone : stones) {
            int row = ~stone[0];
            int col = stone[1];
            parent.put(row, row);
            parent.put(col, col);
        }
        groups = parent.size();
    }
    
    public int find(int x) {
        if( parent.get(x) != x )
            parent.put(x, find(parent.get(x)));
        return parent.get(x);
    }
    
    public void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        
        if( xp == yp ) return;
        
        int rx = rank.getOrDefault(xp, 0);
        int ry = rank.getOrDefault(yp, 0);
        
        if( rx > ry ) 
            parent.put(yp, xp);
        else if( ry > rx ) 
            parent.put(xp, yp);
        else {
            parent.put(yp, xp);
            rank.put(xp, rx+1);
        }
        groups--;
    }
}
// class Solution {
//     public int removeStones(int[][] stones) {
//         int n = stones.length;
//         DSU dsu = new DSU(n);
        
//         for(int i=0; i<n; i++) 
//             for(int j=i+1; j<n; j++) 
//                 if( stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1] )
//                     dsu.union(i, j);
        
//         return n - dsu.groups;
//     }
// }
// class DSU {
//     private int[] parent;
//     private int[] rank;
//     public int groups;
    
//     public DSU(int n) {
//         parent = new int[n];
//         rank = new int[n];
//         groups = n;
        
//         for(int i=0; i<n; i++) {
//             parent[i] = i;
//             rank[i] = 1;
//         }
//     }
    
//     public int find(int x) {
//         if( parent[x] != x )
//             parent[x] = find(parent[x]);
//         return parent[x];
//     }
    
//     public void union(int x, int y) {
//         int xp = find(x);
//         int yp = find(y);
        
//         if( xp == yp ) return;
        
//         if( rank[xp] > rank[yp] ) 
//             parent[yp] = xp;
//         else if( rank[yp] > rank[xp] ) 
//             parent[xp] = yp;
//         else {
//             parent[yp] = xp;
//             rank[xp] += 1;
//         }
//         groups--;
//     }
// }
