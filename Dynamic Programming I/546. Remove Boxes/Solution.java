class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n+1];
        
        for(int[][] arr : dp)
            for(int[] row : arr)
                Arrays.fill(row, -1);
        
        return scoreMax(0, n-1, 0, boxes, dp);
    }
    
    private int scoreMax(int l, int r, int count, int[] boxes, int[][][] dp) {
        if( l > r ) return 0;
                
        if( dp[l][r][count] != -1 )
            return dp[l][r][count];
        
        int tempL = l, tempCount = count;
        
        while( l+1 <= r && boxes[l] == boxes[l+1] ) {
            l++;
            count++;
        }
        count++;
        int ans = count*count + scoreMax(l+1, r, 0, boxes, dp);
        
        for(int m=l+1; m<=r; m++)
            if( boxes[l] == boxes[m] ) 
                ans = Math.max(ans, scoreMax(m, r, count, boxes, dp) + 
                               scoreMax(l+1, m-1, 0, boxes, dp));
        
        return dp[tempL][r][tempCount] = ans;
    }
}
