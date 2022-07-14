class Solution {
    
    private static final int[][] DIR = new int[][]{
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };
    
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean marked = false;
        Queue<int[]> queue = new LinkedList();
        
        // Mark the first island with a different number (2)
        // and add all coordinates of this island into queue
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) 
                if( grid[i][j] == 1 ) {
                    dfsMark(i, j, n, grid, queue);
                    marked = true;
                    break;
                }
            if( marked )
                break;
        }
        
        return bfsMinPath(n, grid, queue);
    }
    
    private void dfsMark(int i, int j, int n, int[][] grid, Queue<int[]> queue) {
        grid[i][j] = 2;
        queue.offer( new int[]{ i, j });
        
        for(int k=0; k<4; k++) {
            int di = i+DIR[k][0];
            int dj = j+DIR[k][1];
            
            if( di < 0 || dj < 0 || di == n || dj == n || grid[di][dj] != 1 )
                continue;
            
            dfsMark(di, dj, n, grid, queue);
        }
    }
    
    private int bfsMinPath(int n, int[][] grid, Queue<int[]> queue) {
        int steps = 0;
        boolean[][] visited = new boolean[n][n];
        
        while( !queue.isEmpty() ) {
            int size = queue.size();
            
            while( size-- > 0 ) {
                int i = queue.peek()[0];
                int j = queue.peek()[1];
                queue.poll();
                
                for(int[] dir : DIR) {
                    int di = i+dir[0];
                    int dj = j+dir[1];

                    if( di < 0 || dj < 0 || di == n || dj == n || grid[di][dj] == 2 || visited[di][dj] )
                        continue;

                    if( grid[di][dj] == 1 )
                        return steps;

                    queue.offer( new int[]{ di, dj });
                    visited[di][dj] = true;  
                }
            }
            steps++;
        }
        return steps;
    }
}
