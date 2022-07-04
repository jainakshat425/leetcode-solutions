class Solution {
    
    private static final int[][] MOVE = new int[][]{
        {-2,-1},
        {2,-1},
        {-2,1},
        {2,1},
        {-1,-2},
        {1,-2},
        {-1,2},
        {1,2}
    };
    private static final int MODULO = 1000000007;
    
    public int knightDialer(int n) {
        int[][][] dp = new int[4][3][n+1];
        int ans = 0;
        
        for(int i=0; i<4; i++) 
            for(int j=0; j<3; j++) 
                ans = (ans + dfs(i, j, n-1, dp)) % MODULO;
        
        return ans;
    }
    
    private int dfs(int i, int j, int n, int[][][] dp) {
        // out of bounds
        if( i < 0 || j < 0 || i >= 4 || j >= 3 )
            return 0;
        // stepped on a non-numeric cell
        if( i == 3 && (j == 0 || j == 2) )
            return 0;
        // no moves left
        if( n == 0 )
            return 1;
        
        if(dp[i][j][n] != 0)
            return dp[i][j][n];
        
        int count = 0;
        
        for(int d=0; d<8; d++) {
            int di = i + MOVE[d][0];
            int dj = j + MOVE[d][1];
            
            count = (count + dfs(di, dj, n-1, dp)) % MODULO;
        }
        return dp[i][j][n] = count;
    }
}
