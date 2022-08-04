class Solution {
    
    private static final int[][] DIR = new int[][]{
        {1,0},{-1,0},{0,1},{0,-1}
    };
    
    public int uniquePathsIII(int[][] grid) {
        int numRows = grid.length, numCols = grid[0].length;
        int startRow = -1, startCol = -1, endRow = -1, endCol = -1;
        int numEmptySquares = 0;
        
        for(int row=0; row<numRows; row++) {
            for(int col=0; col<numCols; col++) {
                if( grid[row][col] == 1 ) {
                    startRow = row;
                    startCol = col;
                }
                else if( grid[row][col] == 2 ) {
                    endRow = row;
                    endCol = col;
                }
                else if( grid[row][col] == 0 ) 
                    numEmptySquares++;
            }
        }
        
        return dfs(startRow, startCol, endRow, endCol, numEmptySquares+1, grid);
    }
    
    private int dfs(int i, int j, int destRow, int destCol, int remainingVisit, int[][] grid) {

        if( i == destRow && j == destCol )
            return remainingVisit == 0 ? 1 : 0;
        
        int numRows = grid.length, numCols = grid[0].length;
        int backup = grid[i][j];
        int count = 0;
        
        grid[i][j] = -1;
        for(int[] dir : DIR) {
            int di = i + dir[0];
            int dj = j + dir[1];
            
            if( di < 0 || dj < 0 || di == numRows || dj == numCols || grid[di][dj] == -1 )
                continue;
            
            count += dfs(di, dj, destRow, destCol, remainingVisit-1, grid);
        }
        grid[i][j] = backup;
        
        return count;
    }
}
