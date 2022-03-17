class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        /*
        1. Declare 
            - {row} and {col} to point to the current element of matrix, initialized to 0.
            - {dir} - variable to store current traversal direction, initialized to 1.
                - Possible values (1 = right, 2 = downwards, 3 = left, 4 = upwards)
            - {rowStart}, {colStart}, {rowEnd}, {colEnd} to control array bounds.
            - {length} - Length of the result array.
            - {result} - to store traversed elements from matrix.
        2. Loop from 0 to {length}
            - Add element at current ({row}, {col}) in {matrix} to the {result}.
            - If direction {dir} is right {1}.
                - If {col} reaches end of the columns
                    - Increase {rowStart} so that current row cannot be traversed again.
                    - Move to the next row.
                    - Change the direction.
                - else, continue to the element in the next column.
            - Repeat steps accordinjly for directions down, left, and up.
        */
        
        if( matrix == null || matrix[0] == null ) {
            return null;
        }
        
        // {row} and {col} to point to the current element of matrix, initialized to 0.
        // {dir} - variable to store current traversal direction, initialized to 1.
        // Possible values (1 = right, 2 = downwards, 3 = left, 4 = upwards)
        int row = 0, col = 0, dir = 1;
        
        // {rowStart}, {colStart}, {rowEnd}, {colEnd} to control array bounds.
        int rowStart = 0, colStart = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
        
        // {length} - Length of the result array.
        int length = matrix.length * matrix[0].length;
        
        // {result} - to store traversed elements from matrix.
        List<Integer> result = new ArrayList<Integer>();
        
        // Loop from 0 to {length}
        for(int i=0; i<length; i++) {
            
            // Add element at current ({row}, {col}) in {matrix} to the {result}.
            result.add( matrix[row][col] );
            
            // If direction {dir} is right {1}.
            if( dir == 1 ) {
                
                //  If {col} reaches end of the columns
                if( col == colEnd ) {
                    
                    // Increase {rowStart} so that current row cannot be traversed again.
                    rowStart++;
                    
                    // Move to the next row.
                    row++;
                    
                    // Change the direction.
                    dir++;
                    
                } else {
                    
                    // continue to the element in the next column.
                    col++;
                }
            } else if( dir == 2 ) {
                
                if( row == rowEnd ) {
                    colEnd--;
                    col--;
                    dir++;
                } else {
                    row++;
                }
            } else if( dir == 3 ) {
                
                if( col == colStart ) {
                    rowEnd--;
                    row--;
                    dir++;
                } else {
                    col--;
                }
            } else if( dir == 4 ) {
                
                if( row == rowStart ) {
                    colStart++;
                    col++;
                    dir = 1;
                } else {
                    row--;
                }
            }
        }
        return result;
    }
}
