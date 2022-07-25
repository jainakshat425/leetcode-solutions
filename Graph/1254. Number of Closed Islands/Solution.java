class Solution {
    
    private static final int[][] DIR = new int[][]{
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };
    
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        
        for(int i=0; i<m; i++) 
            for(int j=0; j<n; j++) 
                if( grid[i][j] == 0 && isClosed(i,j,m,n,grid) )
                    ans++;
        
        return ans;
    }
    
    private boolean isClosed(int i, int j, int m, int n, int[][] grid) {
        // mark visited
        grid[i][j] = 2;
        
        for(int[] dir : DIR) {
            int di = i + dir[0];
            int dj = j + dir[1];
            
            boolean isClosed = true;
            
            if( di < 0 || dj < 0 || di == m || dj == n || grid[di][dj] == -1 )
                isClosed = false;
            
            else if( grid[di][dj] == 0 && !isClosed(di,dj,m,n,grid) )
                isClosed = false;
            
            if( !isClosed ) {
                // mark it as open island
                grid[i][j] = -1;
                return false;
            }
        }
        return true;
    }
}
