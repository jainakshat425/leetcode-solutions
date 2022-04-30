class Solution {
    private static final int SIZE = 9;
    
    public void solveSudoku(char[][] board) {
        boolean result = solveSudoku(board, 0);
    }
    
    private boolean solveSudoku(char[][] board, int rowStart) {
        for(int row = rowStart; row < SIZE; row++) {
            
            for(int col = 0; col < SIZE; col++) {
                
                // If current cell need to be filled
                if( board[row][col] == '.' ) {
            
                    // Try to fill current cell with number from 1 to 9
                    for(char num = '1'; num <= (SIZE+'0'); num++) {

                        // Check if number is valid for current row, column and block
                        if( isValid( board, row, col, num ) ) {

                            // Fill the current number into the cell 
                            board[row][col] = num;

                            /* Try to fill next cells, and if it's possible 
                            to complete the sudoku in this path return true */
                            if( solveSudoku(board, row) ) {
                                return true;
                            }
                        }
                    }
                    
                    // No able to complete the sudoku in this path, hence backtrack
                    // Empty the current cell and return false
                    board[row][col] = '.';
                    return false;
                }
            }
        }
        // All the numbers must be filled
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char num) {
        
        // Start index of first cell of current block
        int rowStart = (row/3) * 3;
        int colStart = (col/3) * 3;
        
        for(int i=0; i<SIZE; i++) {
            // is duplicate in row
            if( board[row][i] == num )  return false;

            // is duplicate in column
            if( board[i][col] == num ) return false;
            
            // is duplicate in block
            int blockRow = rowStart + i/3;
            int blockCol = colStart + i%3;
            
            if( board[blockRow][blockCol] == num ) return false;
        }
        
        return true;
    }
}
