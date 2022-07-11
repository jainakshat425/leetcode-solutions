class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[][]{ p1, p2, p3, p4 };
        TreeMap<Integer,Integer> distCount = new TreeMap();
        
        for(int i=0; i<4; i++) {
            for(int j=i+1; j<4; j++) {          
                // Distance between two points, skip the sqrt
                int dist = distance(points[i], points[j]);
                distCount.put(dist, distCount.getOrDefault(dist, 0)+1);
            }
        }
        
        if( distCount.size() != 2 )
            return false;
        
        int side = distCount.firstKey(), diag = distCount.lastKey();
        return side != diag && distCount.get(diag) == 2 && distCount.get(side) == 4;
    }
    
    private int distance(int[] p1, int[] p2) {
        int x_dist = p2[0] - p1[0];
        int y_dist = p2[1] - p1[1];
        return x_dist * x_dist + y_dist * y_dist;
    }
}
