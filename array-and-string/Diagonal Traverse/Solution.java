class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        /*
        1 2 3
        4 5 6
        7 8 9
        1   2   4   7  5  3   6  8   9
        00, 01 10, 20 11 02, 12 21, 22
        0   1   2   3  4  5   6  7   8
        */
        
        /* 
        1. Create a result array {result} of size equals to {no. of rows * no. of cols} in matrix {mat}.
        2. Create a row {row} and column {col} pointer, initialized to 0.
        3. Iterate over {result}, and copy element at ({row}, {col}) index from matrix.
        4. For each element {mat[row][col]}, if sum of indices {row} and {col} is even,
            then we need to traverse updwards, else downwards.
            4a. If sum is even
                - if {col} points to the last column
                    - Increment {row} 
                - else if {row} equals to 0
                    - Increment {col} 
                - else
                    - Decrement {row} and Increment {col}
            4b. else (sum is odd)
                 - if {row} points to the last row
                    - Increment {col} 
                - else if {col} equals to 0
                    - Increment {row} 
                - else
                    - Decrement {col} and Increment {row}
        */
        
        if( mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0 ) {
            return null;
        }
        int m = mat.length, n = mat[0].length;
        
        // Create a result array {result} of size equals to 
        // {no. of rows * no. of cols} in matrix {mat}.
        int[] result = new int[m * n];
        
        // Create a row {row} and column {col} pointer, initialized to 0.
        int row = 0, col = 0;
        
        // For each element {mat[row][col]}, if sum of indices {row} and {col} is even,
        // then we need to traverse updwards, else downwards.
        for(int i=0; i<result.length; i++) {
            
            // Iterate over {result}, and copy element at ({row}, {col}) index from matrix.
            result[i] = mat[row][col];
            
            // If sum is even
            if( ((row+col)%2) == 0 ) {
                
                // if {col} points to the last column
                if( col == (n-1) ) {
                    row++;
                } else if( row == 0 ) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {
                
                // if {row} points to the last row
                if( row == (m-1) ) {
                    col++;
                } else if( col == 0 ) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
            
        }
        return result;
    }
}
