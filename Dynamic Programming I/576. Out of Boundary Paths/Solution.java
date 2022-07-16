class Solution {
    
    private static final int[][] DIR = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    private static final int MAX = 1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startCol) {
        Integer[][][] dp = new Integer[m][n][maxMove+1];
        return findPaths(m, n, maxMove, startRow, startCol, dp);
    }
    
    private int findPaths(int m, int n, int maxMove, int row, int col, Integer[][][] dp) {
        if( row < 0 || col < 0 || row == m || col == n )
            return 1;
        
        if( maxMove == 0 )
            return 0;
        
        if( dp[row][col][maxMove] != null )
            return dp[row][col][maxMove];
        
        int moves = 0;
        for(int[] dir : DIR) 
            moves = (moves + findPaths(m, n, maxMove-1, row+dir[0], col+dir[1], dp)) % MAX;
        
        return dp[row][col][maxMove] = moves % MAX;
    }
}
