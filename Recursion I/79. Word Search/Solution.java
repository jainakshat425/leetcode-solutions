class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( exist(i, j, 0, board, word) ) 
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean exist(int i, int j, int k, char[][] board, String word) {
        if( i < 0 || j < 0 || i >= board.length || j >= board[0].length )
            return false;
        if( board[i][j] != word.charAt(k) )
            return false;
        if( k == word.length() - 1 )
            return true;
        
        board[i][j] = '\0';
        
        boolean found = exist(i+1, j, k+1, board, word) || // up
            exist(i, j+1, k+1, board, word) || // right
            exist(i-1, j, k+1, board, word) || // bottom
            exist(i, j-1, k+1, board, word); // left
        
        board[i][j] = word.charAt(k);
        return found;
    }
}
