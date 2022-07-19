class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int dest = n*n;
        int moves = 0;
        boolean[] visited = new boolean[dest+1];
        Queue<Integer> queue = new LinkedList();
        
        queue.offer(1);
        visited[1] = true;
        
        while( !queue.isEmpty() ) {
            moves++;
            
            int size = queue.size();
            
            while( size-- > 0 ) {
                int cellNo = queue.poll();
                int maxMove = Math.min(cellNo+6, dest);
                
                for(int nextMove=cellNo + 1; nextMove<=maxMove; nextMove++) {
                    
                    if( visited[nextMove] )
                        continue;
                    if( nextMove == dest  )
                        return moves;
                    
                    visited[nextMove] = true;
                    
                    int val = getBoardValue(nextMove, n, board);
                    
                    if( val == dest )
                        return moves;
                    
                    queue.offer(val);
                }
            }
        }
        return -1;
    }
    
    private int getBoardValue(int cellNo, int n, int[][] board) {
        // Index of the row, when matrix is reversed by rows
        int reverseRow = (cellNo - 1)/n;
        int row = n - 1 - reverseRow;
        // cellNo = 19, reverseRow = 3, row = 2, col = 0, reverseCol = 5
        int col = (cellNo - 1) % n;
        
        // If reverseRow is odd, reverse the column number
        if( reverseRow % 2 != 0 ) 
            col = n - 1 - col;
            
        return board[row][col] == -1 ? cellNo : board[row][col];
    }
}
