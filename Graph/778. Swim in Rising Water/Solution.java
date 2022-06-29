class Solution {
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
        // (row, col, max value till current cell from start)
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[2],b[2]));
        
        pq.offer(new int[]{0, 0, grid[0][0]});
        vis[0][0] = true;
        
        while( !pq.isEmpty() ) {
            int r = pq.peek()[0];
            int c = pq.peek()[1];
            int t = pq.peek()[2];
            pq.poll();
            
            if( r == n-1 && c == n-1 )
                return t;
            
            for(int i=0; i<4; i++) {
                int dr = r + dir[i][0];
                int dc = c + dir[i][1];
                
                if( dr < 0 || dc < 0 || dr >= n || dc >= n || vis[dr][dc] )
                    continue;
                
                int new_t = Math.max(t, grid[dr][dc]);                
                pq.offer(new int[]{ dr, dc, new_t });
                vis[dr][dc] = true;
            }
        }
        return -1;
    }
}
