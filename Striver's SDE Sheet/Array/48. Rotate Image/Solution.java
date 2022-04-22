class Solution {
    public void rotate(int[][] matrix) {
        /* 
        1 2 3                           3 2 1
        4 5 6  -> Reverse each row ->   6 5 4 
        7 8 9                           9 8 7
        
        For each row, swap the current element with it's diagonally opposite element.
        No need to swap till last index and keep shrinking the number of columns as we move down the array
        For row 1 
        3 (0,0) <=> 7 (2,2)
        2 (0,1) <=> 4 (1,2)
        
        For row 2, the matrix shrinks down to
        6 5
        9 8
        
        6 (1,0) <=> 8 (2,1)
        
        Done✌️.
        */
        
        // Row and column length of matrix
        int n = matrix.length;
        
        // Last index of a row/col
        int lastIndex = n-1;
        
        // Iterate over each row and reverse it
        for(int[] row : matrix) {
            reverse(row, 0, lastIndex);
        }
        
        // Iterate from first row to the second last row
        for(int row = 0; row < lastIndex; row++) {
            
            // No need to swap till last index, keep shrinking the number of columns as we move down the array
            int lastCol = lastIndex-row;
            
            // For each element in the current row
            for(int col = 0; col < lastCol; col++) {
                
                // As we move forward in the columns, assume current element as the first element of shrinked matrix and hence {lastRow} will be the index of the last row of this shriked matrix.
                int lastRow = lastIndex-col;
                
                // Swap the current element with it's diagonally opposite element.
                swap2D(matrix, row, col, lastRow, lastCol);
            }
        }
    }
    
    private void reverse(int[] arr, int start, int end) {
        while(start < end) {
            swap(arr, start, end);
            ++start;
            --end;
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private void swap2D(int[][] matrix, int row1, int col1, int row2, int col2) {
        int temp = matrix[row1][col1];
                
        matrix[row1][col1] = matrix[row2][col2];
                
        matrix[row2][col2] = temp;   
    }
}
