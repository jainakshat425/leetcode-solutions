// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        
        ArrayList<String> result = new ArrayList<String>();
        
        // Start finding path from cell (0,0) 
        findPath(m, n, 0, 0, new StringBuilder(), result);
        
        return result;
    }
    
    private static void findPath(
        int[][] m, int n, int row, int col,  
        StringBuilder path,  ArrayList<String> result) {
            
        /* Return if current row or column is out of array bounds 
        or current cell is 0 or visited */
        if( row < 0 || col < 0 || row >= n || col >= n || m[row][col] == 0 ) {
            return;
        }
        /* If reached to the last cell, add current path to result */
        if( row == n-1 && col == n-1 ) {
            result.add( path.toString() );
            return;
        }
        
        // Mark the current cell as visited
        m[row][col] = 0;
        
        /* For each direction perform following steps - 
        1. Append the path character for to the current path  
        2. Call findPath for that direction.
        3. once a search is completed in one direction, remove 
        the appended character for that direction */
        
        // Upward direction (row-1)
        path.append("U");
        findPath(m, n, row-1, col, path, result);
        deleteLastChar( path );
        
        // Downward direction (row+1)
        path.append("D");
        findPath(m, n, row+1, col,  path, result);
        deleteLastChar( path );
        
        // Left direction (col-1)
        path.append("L");
        findPath(m, n, row, col-1, path, result);
        deleteLastChar( path );
        
        // Right direction (col+1)
        path.append("R");
        findPath(m, n, row, col+1, path, result);
        deleteLastChar( path );
        
        // Restore the value of current cell
        m[row][col] = 1;
    }
    
    private static void deleteLastChar(StringBuilder str) {
        str.deleteCharAt( str.length() - 1 );
    }
}
