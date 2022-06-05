class Solution {
    public int totalNQueens(int n) {
        return solveNQueens(0, n, new boolean[n][n]);
    }

    private int solveNQueens(int row, int n, boolean[][] board) {
        if( row == n ) {
            return 1;
        }

        int count = 0;
        for(int col=0; col<n; col++) {
            if( isSafe(row, col, n, board) ) {
                board[row][col] = true;
                count += solveNQueens(row+1, n, board);
                board[row][col] = false;
            }
        }
        return count;
    }

    private boolean isSafe(int row, int col, int n, boolean[][] board) {
        // is column safe?
        for(int i=0; i<row; i++) {
            if( board[i][col] )
                return false;
        }

        // is diagonal safe?
        for(int i=0; row-i >= 0 && col-i >= 0; i++) {
            if( board[row-i][col-i] )
                return false;
        }

        // is anti-diagonal safe?
        for(int i=0; row-i >= 0 && col+i < n; i++) {
            if( board[row-i][col+i] )
                return false;
        }
        return true;
    }
}

