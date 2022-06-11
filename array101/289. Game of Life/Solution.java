class Solution {
    
    private static final int LIVE = 1;
    private static final int DEAD = 0;
    private static final int NEW_LIVE = 2;
    private static final int NEW_DEAD = -1;
    
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                
                int count = getLiveNeighbourCount(i, j, m, n, board);
                
                if( board[i][j] == LIVE ) {
                    if( count < 2 || count > 3 )
                        board[i][j] = NEW_DEAD;
                    
                } else if( board[i][j] == DEAD ) {
                    if( count == 3 )
                        board[i][j] = NEW_LIVE;
                }
            }
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                
                if( board[i][j] == NEW_DEAD ) 
                    board[i][j] = DEAD;
                    
                else if( board[i][j] == NEW_LIVE ) 
                    board[i][j] = LIVE;
            }
        }
    }
    
    private int getLiveNeighbourCount(int row, int col, int m, int n, int[][] board) {
        int count = 0;
        
        int startRow = Math.max(0, row-1);
        int startCol = Math.max(0, col-1);
        int endRow = Math.min(m-1, row+1);
        int endCol = Math.min(n-1, col+1);
        
        for(int i=startRow; i<=endRow; i++) {
            for(int j=startCol; j<=endCol; j++) {
                
                if( i == row && j == col )
                    continue;
                
                if( board[i][j] == LIVE || board[i][j] == NEW_DEAD ) 
                    count++;
            }
        }
        return count;
    }
}
