class Solution {
        
    public int numIslands(char[][] grid) {
        /* 
        1. Create a boolean array {visited} to mark visited nodes.
        2. Repeat for each element of grid
            - if current grid element is 1 and it's not visited.
            - increment the count and recursively mark the current island as visited.
        */
        
        int m = grid.length, n = grid[0].length;
        
        // Create a boolean array {visited} to mark visited nodes.
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        
        // Repeat for each element of grid
        for(int i=0; i<m; i++) {
            
            for(int j=0; j<n; j++) {
                
                // if current grid element is 1 and it's not visited.
                if( grid[i][j] == '1' && !visited[i][j] ) {
                    
                    // increment the count and recursively mark the current island as visited.
                    count++;
                    markIsland(grid, visited, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void markIsland(char[][] grid, boolean[][] visited, int i, int j) {
        if( grid[i][j] == '0' || visited[i][j] ) return;
        
        visited[i][j] = true;
        
        if( i > 0 ) {
            markIsland(grid, visited, i-1, j);
        }
        if( j > 0 ) {
            markIsland(grid, visited, i, j-1);
        }
        if( i < visited.length-1 ) {
            markIsland(grid, visited, i+1, j);
        }
        if( j < visited[0].length-1 ) {
            markIsland(grid, visited, i, j+1);
        }
    }
}
