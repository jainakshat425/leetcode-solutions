class Solution {
    
    private static final int[] DIR_Y = new int[]{-1, 0, 1, 0};
    private static final int[] DIR_X = new int[]{0, 1, 0, -1};
    
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++) {
            if( board[i][0] == 'O' )
                dfs(i, 0, m, n, board);
            if( board[i][n-1] == 'O' )
                dfs(i, n-1, m, n, board);
        }
        
        for(int j=1; j<n-1; j++) {
            if( board[0][j] == 'O' )
                dfs(0, j, m, n, board);
            if( board[m-1][j] == 'O' )
                dfs(m-1, j, m, n, board);
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( board[i][j] == 'O' )
                    board[i][j] = 'X';
                else if( board[i][j] == '#' )
                    board[i][j] = 'O';
            }
        }
    }
    
    private void dfs(int i, int j, int m, int n, char[][] board) {
        if( i == m || j == n || i < 0 || j < 0 || board[i][j] != 'O' )
            return;
        
        board[i][j] = '#';
        
        for(int k=0; k<4; k++) {
            int dx = j + DIR_X[k];
            int dy = i + DIR_Y[k];
            
            dfs(dy, dx, m, n, board);
        }
    }
}
