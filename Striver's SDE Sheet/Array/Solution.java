class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        /*
        Since (0,0) will cause confusion regarding whether to mark 
        0th column as 0 or 0th row as 0, we can use seperate variable 
        to identify whether to mark first row as 0 or not. And (0,0)
        can then be used to identify whether to mark first column as 0 or not.
        */
        boolean firstRowZero = false;
        
        for(int row=0; row<m; row++) {
            
            for(int col=0; col<n; col++) {
                
                // Mark the first cell of current row and colun to zero
                // if current element is 0
                if( matrix[row][col] == 0 ) {
                    // set first cell of current col to 0
                    // to indicate that current column needs to be 0.
                    matrix[0][col] = 0;

                    // set first cell of current row to 0
                    // to indicate that current row needs to be 0.
                    if( row == 0 ) {
                        firstRowZero = true;
                    } else {
                        matrix[row][0] = 0;
                    }
                }
            }
        }
        
        // Iterate from the last cell of the matrix
        for(int row=m-1; row>=0; row--) {
            
            for(int col=n-1; col>=0; col--) {
                
                // Use {firstRowZero} to mark current row zero, if the current row index is 0
                if( row == 0 ) {
                    if( firstRowZero ) {
                        matrix[row][col] = 0;
                    }
                } 
                // Else check the respective first column and row cell to identify if current
                // cell need to be marked 0
                else if( matrix[0][col] == 0 || matrix[row][0] == 0 ) {
                    matrix[row][col] = 0;
                } 
            }
        }
    }
}
