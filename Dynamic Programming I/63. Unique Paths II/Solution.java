class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if( obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1 )
            return 0;
        
        int[] prev = new int[n];
        int[] curr = new int[n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( obstacleGrid[i][j] == 1 ) {
                    curr[j] = 0;
                }
                else if( i == 0 && j == 0 ) {
                    curr[j] = 1;
                }
                else {
                    int up = i == 0 ? 0 : prev[j];
                    int left = j == 0 ? 0 : curr[j-1];

                    curr[j] = up + left;
                }
            }
            prev = curr;
        }
            
        return prev[n-1];
    }
}
/* 
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if( obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1 )
            return 0;
        
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                
                if( i == 0 && j == 0 ) continue;
                if( obstacleGrid[i][j] == 1 ) continue;
                
                int up = i == 0 ? 0 : dp[i-1][j];
                int left = j == 0 ? 0 : dp[i][j-1];

                dp[i][j] = up + left;
            }
        }
            
        return dp[m-1][n-1];
    }
}
*/
/* 
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++)
            Arrays.fill(dp[i], -1);
            
        return uniquePaths(m-1, n-1, obstacleGrid, dp);
    }
    
    private int uniquePaths(int i, int j, int[][] grid, int[][] dp) {
        if( i < 0 || j < 0 || grid[i][j] == 1 )
            return 0;
        
        if( i == 0 && j == 0 )
            return 1;
        
        if( dp[i][j] != -1 ) 
            return dp[i][j];
                
        int up = uniquePaths(i-1, j, grid, dp);
        int left = uniquePaths(i, j-1, grid, dp);
        
        return dp[i][j] = up + left;
    }
}
*/
