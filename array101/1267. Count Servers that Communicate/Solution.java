class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( grid[i][j] == 1 ) 
                    count += countConnections(i, j, m, n, grid);
            }
        }
        
        // for(int i=0; i<m; i++) {
        //     for(int j=0; j<n; j++) {
        //         if( grid[i][j] == -1 )
        //             grid[i][j] = 1;
        //     }
        // }
        return count;
    }
    
    private int countConnections(int row, int col, int m, int n, int[][] grid) {
        int count = 0;
        boolean hasConnection = false;
        // check column
        for(int i=0; i<m; i++) {
            if( i == row ) continue;
            
            if( grid[i][col] == 1 ) {
                grid[i][col] = -1;
                count++;
            }      
            if( grid[i][col] == -1 )
                hasConnection = true;
        }
        
        // check row
        for(int j=0; j<n; j++) {
            if( j == col ) continue;
            
            if( grid[row][j] == 1 ) {
                grid[row][j] = -1;
                count++;
            }   
            if( grid[row][j] == -1 )
                hasConnection = true;
        }
        if( hasConnection )
            count++;
        return count;
    }
}
