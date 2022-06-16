class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        // check rows
        for(int i=0; i<n; i++) {
            Set<Character> seen = new HashSet();
            for(int j=0; j<n; j++) {
                if( board[i][j] == '.' )
                    continue;
                if( seen.contains( board[i][j] ) ) 
                    return false;
                seen.add( board[i][j]);
            }
        }
        
        // check col
        for(int j=0; j<n; j++) {
            Set<Character> seen = new HashSet();
            for(int i=0; i<n; i++) {
                if( board[i][j] == '.' )
                    continue;
                if( seen.contains( board[i][j] ) ) 
                    return false;
                seen.add( board[i][j]);
            }
        }
        
        // check 3*3
        for(int startI=0; startI<n; startI+=3) {
            for(int startJ=0; startJ<n; startJ+=3) {
                Set<Character> seen = new HashSet();
                for(int i=startI; i<startI+3; i++) {
                    for(int j=startJ; j<startJ+3; j++) {
                        if( board[i][j] == '.' )
                            continue;
                        if( seen.contains( board[i][j] ) ) 
                            return false;
                        seen.add( board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
