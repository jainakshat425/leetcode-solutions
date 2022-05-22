class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] dp = new int[n];
        
        for(int i=0; i<m; i++) {
            
            for(int j=0; j<n; j++) {
                
                if( i == 0 && j == 0 ) 
                    dp[j] = grid[i][j];
                else {
                     int up = i == 0 ? Integer.MAX_VALUE : dp[j];
                    int left = j == 0 ? Integer.MAX_VALUE : dp[j-1];

                    dp[j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
            
        return dp[n-1];
    }
}
/*
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        for(int[] state : dp)
            Arrays.fill(state, -1);
        
        return mps(m-1, n-1, grid, dp);
    }
    
    private int mps(int i, int j, int[][] grid, int[][] dp) {
        if( i < 0 || j < 0 )
            return Integer.MAX_VALUE;
        
        if( i == 0 && j == 0 )
            return grid[i][j];
        
        if( dp[i][j] != -1 ) return dp[i][j];
        
        int up = mps(i-1, j, grid, dp);
        int left = mps(i, j-1, grid, dp);
        
        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }
}
*/
