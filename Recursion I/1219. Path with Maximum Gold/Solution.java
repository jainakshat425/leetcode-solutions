class Solution {
    
    private static final int[][] DIRS = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    
    public int getMaximumGold(int[][] grid) {
        int numRows = grid.length, numCols = grid[0].length;
        int max = 0;
        
        for(int row=0; row<numRows; row++) 
            for(int col=0; col<numCols; col++)
                if( grid[row][col] > 0 )
                    max = Math.max(max, collectMax(row, col, grid));
        
        return max;
    }
    
    private int collectMax(int row, int col, int[][] grid) {
        int numRows = grid.length, numCols = grid[0].length;
        int max = 0; 
        int backup = grid[row][col];
        grid[row][col] = 0;
        
        for(int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if( newRow < 0 || newCol < 0 || newRow == numRows || newCol == numCols )
                continue;
            
            if( grid[newRow][newCol] > 0 )
                max = Math.max(max, collectMax(newRow, newCol, grid));
        }
        
        grid[row][col] = backup;
        
        return grid[row][col] + max;
    }
}
