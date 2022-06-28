class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] inMST = new boolean[n];
        int[] minDist = new int[n];
        int ans = 0;
        
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        
        int i = 0;
        while( i != -1 ) {            
            inMST[i] = true;
            ans += minDist[i];
                
            int new_i = -1;
            for(int j=1; j<n; j++) {
                if( !inMST[j] ) {
                    minDist[j] = Math.min(minDist[j], manhattanDist(points[i], points[j]));
                    
                    if( new_i == -1 || minDist[j] < minDist[new_i] )
                        new_i = j;
                }
            }
            i = new_i;
        }
        return ans;
    }
    
    private int manhattanDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
/* 
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] inMST = new boolean[n];
        // No. of remaining vertex to be included in MST
        int required = n;
        int ans = 0;
        // 0 > index of a point, 1 > distance from some point to this point
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{ 0, 0 });
        
        while( required != 0 ) {
            int i = pq.peek()[0];
            int dist = pq.peek()[1];
            pq.poll();
            
            if( inMST[i] )
                continue;
            
            inMST[i] = true;
            ans += dist;
            required--;
            
            for(int j=1; j<n; j++)
                if( !inMST[j] )
                    pq.offer(new int[]{ j, manhattanDist(points[i], points[j]) });
            
        }
        return ans;
    }
    
    private int manhattanDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
*/
/* 
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // No. of edges required
        int required = n-1;
        int ans = 0;
        DSU dsu = new DSU(n);
        // 0 > index of 1st point, 1 > index of 2nd point, 2 > distance between 1st & 2nd
        PriorityQueue<int[]> edges = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
        
        for(int i=0; i<n; i++) 
            for(int j=i+1; j<n; j++) 
                edges.offer(new int[]{i, j, manhattanDist(points[i], points[j])});
        
        while( required != 0 ) {
            int[] edge = edges.poll();
            
            if( dsu.union(edge[0], edge[1]) ) {
                ans += edge[2];
                required--;
            }
        }
        return ans;
    }
    
    private int manhattanDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
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
*/
// INCORRECT
// class Solution {
//     public int minCostConnectPoints(int[][] points) {
//         int n = points.length;
//         int ans = 0;
        
//         Arrays.sort(points, (a,b) -> distFromOrigin(a) - distFromOrigin(b));
        
//         for(int i=0; i<n-1; i++) 
//             ans += manhattanDist(points[i], points[i+1]);
        
//         return ans;
//     }
    
//     private int manhattanDist(int[] a, int[] b) {
//         return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
//     }
    
//     private int distFromOrigin(int[] a) {
//         return manhattanDist(a, new int[]{ 0, 0 });
//     }
// }
