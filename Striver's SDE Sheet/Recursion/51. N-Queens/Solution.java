class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        // Create n*n board and fill it with dots "."
        char[][] board = new char[n][n];
        
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        // Call recursive function for 0th row
        solveNQueens(board, n, 0, result);
        
        return result;
    }
    
    private void solveNQueens(char[][] board, int n, int row, List<List<String>> result) {
        /* If all the queens have been placed in current path, 
        put the formatted result into list and backtrack. */
        if( row == n ) {
            result.add( formatResult( board ) );
            return;
        }
        
        /* Try to place the queen in each column of the current row */
        for(int col=0; col<n; col++) {
            
            // Check current queen is safe at current column in the row
            if( isSafe( board, n, row, col ) ) {
                
                // Place the queen at current column
                board[row][col] = 'Q';
                
                // Try to place the next queen in the row
                solveNQueens(board, n, row+1, result);
                
                /* Remove the queen after the current combination has been 
                tried */
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isSafe(char[][] board, int n, int row, int col) {

        // Is column safe
        for(int i=0; i<row; i++) {
            if( board[i][col] == 'Q' ) {
                return false;
            }
        }
        
        // Left to right falling diagonal safe
        int tempRow = row-1, tempCol = col-1;
        
        while( tempRow >= 0 && tempCol >= 0 ) {
            
            if( board[tempRow][tempCol] == 'Q' ) return false;

            tempRow--;
            tempCol--;
        }
        
        // Right to left falling diagonal safe
        tempRow = row-1; 
        tempCol = col+1;
        
        while( tempRow >= 0 && tempCol < n ) {
            
            if( board[tempRow][tempCol] == 'Q' ) return false;
            
            tempRow--;
            tempCol++;
        }
        
        return true;
    }
    
    private List<String> formatResult(char[][] board) {
        List<String> result = new ArrayList<>();
        
        for(char[] row : board) {
            result.add( new String( row ) );
        }
        return result;
    }
}
