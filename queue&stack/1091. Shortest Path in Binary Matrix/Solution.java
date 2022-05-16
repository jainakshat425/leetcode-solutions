class Solution {
    private static final int[] DIR_X = new int[] {-1,-1,0,1,1,1,0,-1};
    private static final int[] DIR_Y = new int[] {0,1,1,1,0,-1,-1,-1};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if( grid[0][0] == 1 || grid[m-1][n-1] == 1 ) 
            return -1;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList();
        queue.offer( new int[] {0,0} );
        visited[0][0] = true;
        
        int ans = 0;
        
        while( !queue.isEmpty() ) {
            int size =  queue.size();
            
            while( size-- > 0 ) {
                
                int x = queue.peek()[0];
                int y = queue.peek()[1];
                queue.poll();
                
                if( x == m-1 && y == n-1 )
                        return ans+1;
                
                for(int i=0; i<8; i++) {
                    int nextX = x + DIR_X[i];
                    int nextY = y + DIR_Y[i];

                    if( nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || grid[nextX][nextY] == 1 || visited[nextX][nextY] )
                        continue;

                    queue.offer( new int[] {nextX,nextY} );
                    visited[nextX][nextY] = true;
                }
            }
            
            ans++;
        }
        
        return -1;
    }
}
