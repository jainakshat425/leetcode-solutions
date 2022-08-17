class Solution {
    
    private static final int[][] DIRS = new int[][]{
        {-1,-1}, {0,0}, {1,1},
        {-1,0}, {-1,1},
        {0,-1}, {0,1},
        {1,0}, {1,-1}
    };
    
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m+1][n][n];
        
        for(int i=m-1; i>=0; i--) {
            for(int j1=0; j1<n; j1++) {
                for(int j2=0; j2<n; j2++) {
                    
                    int picked = grid[i][j1];
                    if( j1 != j2 ) 
                        picked += grid[i][j2];
                    
                    int max = 0;
                    int di = i+1;

                    for(int[] dir : DIRS) {
                        int dj1 = j1 + dir[0];
                        int dj2 = j2 + dir[1];

                        if( dj1 < 0 || dj2 < 0 || dj1 == n || dj2 == n )
                            continue;

                        max = Math.max(max, picked + dp[di][dj1][dj2]);
                    }

                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][n-1];
    }
}   
// class Solution {
    
//     private static final int[][] DIRS = new int[][]{
//         {-1,-1}, {0,0}, {1,1},
//         {-1,0}, {-1,1},
//         {0,-1}, {0,1},
//         {1,0}, {1,-1}
//     };
    
//     public int cherryPickup(int[][] grid) {
//         int m = grid.length, n = grid[0].length;
//         int[][][] dp = new int[m][n][n];
        
//         for(int[][] arr : dp)
//             for(int[] row : arr)
//                 Arrays.fill(row, -1);
        
//         return grid[0][0] + grid[0][n-1] + cherryPick(0, 0, n-1, grid, dp);
//     }
    
//     private int cherryPick(int i, int j1, int j2, int[][] grid, int[][][] dp) {
//         int m = grid.length, n = grid[0].length;
        
//         if( i == m-1 )
//             return 0;
        
//         if( dp[i][j1][j2] != -1 )
//             return dp[i][j1][j2];
        
//         int max = 0;
//         int di = i+1;
        
//         for(int[] dir : DIRS) {
//             int dj1 = j1 + dir[0];
//             int dj2 = j2 + dir[1];

//             if( dj1 < 0 || dj2 < 0 || dj1 == n || dj2 == n )
//                 continue;

//             int picked = dj1 == dj2 ? grid[di][dj1] : grid[di][dj1] + grid[di][dj2];
//             max = Math.max(max, picked + cherryPick(di, dj1, dj2, grid, dp));
//         }
        
//         return dp[i][j1][j2] = max;
//     }
// }
