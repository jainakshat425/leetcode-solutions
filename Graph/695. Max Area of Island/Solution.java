class Solution {
    private static final int[][] DIR = new int[][]{
        {1,0},  // up
        {-1,0}, // bottom
        {0,-1}, // left
        {0,1}   // right
    };
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( grid[i][j] != 1 ) 
                    continue;
                
                int area = bfs(i, j, m, n, grid);
                max = Math.max(max, area);
            }
        }
        
        /* Change -1 to 1 to retain original array */
        return max;
    }
    
    private int bfs(int row, int col, int m, int n, int[][] grid) {
        int area = 0;
        // 0 > Row, 1 > Column
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{ row, col });
        grid[row][col] = -1;
        
        while( !queue.isEmpty() ) {
            int i = queue.peek()[0];
            int j = queue.peek()[1];
            queue.poll();
            area++;
            
            for(int dir=0; dir<4; dir++) {
                int di = i + DIR[dir][0];
                int dj = j + DIR[dir][1];
                
                if( di < 0 || dj < 0 || di > m-1 || dj > n-1 || grid[di][dj] != 1 )
                    continue;
                
                grid[di][dj] = -1;
                queue.offer(new int[]{ di, dj });
            }
        }
        
        return area;
    }
}
