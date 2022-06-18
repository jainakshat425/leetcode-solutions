class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                dp[i][j] = dp[i][j] = -1;
                
        return isMatch(0, 0, s, p, dp) == 1;
    }
    
    private int isMatch(int i, int j, String s, String p, int[][] dp) {
        int m = s.length();
        int n = p.length();
        
        if( j == n )
            return i == m ? 1 : 0;
        
        if( i == m ) {
            while( j+1 < n &&  p.charAt(j+1) == '*' )
                j += 2;
            
            return j == n ? 1 : 0;
        }
        
        if( dp[i][j] != -1 ) return dp[i][j];
        
        boolean ans = false;
        char currS = s.charAt(i);
        char currP = p.charAt(j);
        char nextP = j+1 < n ?  p.charAt(j+1) : '\0';
        boolean currMatches = currS == currP || currP == '.';
        
        // System.out.println(currS + " " + currP + " " + nextP);
        if( nextP == '*' ) {
            boolean skip = isMatch(i, j+2, s, p, dp) == 1;
            boolean take = currMatches && isMatch(i+1, j, s, p, dp) == 1;
            ans = skip || take;
        } else 
            ans = currMatches && isMatch(i+1, j+1, s, p, dp) == 1;
        
        return dp[i][j] = ans ? 1 : 0;
    }
}
/* 
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][][] dp = new int[m+1][n+1][2];
        
        for(int i=0; i<=m; i++)
            for(int j=0; j<=n; j++)
                dp[i][j][0] = dp[i][j][1] = -1;
                
        return isMatch(m, n, 0, s, p, dp) == 1;
    }
    
    private int isMatch(int i, int j, int star, String s, String p, int[][][] dp) {
        if( i == 0 && j == 0 )
            return 1;
        
        if( j == 0 )
            return 0;
        
        if( i == 0 ) {
            
            if( star == 1 )
                --j;
            
            while( j > 0 && p.charAt(j-1) == '*' ) 
                j -= 2;
            
            return j == 0 ? 1 : 0;
        }
        
        if( dp[i][j][star] != -1 ) return dp[i][j][star];
        
        char charS = s.charAt(i-1);
        char charP = p.charAt(j-1);
        
        if( star == 1 ) {
            if( charS == charP || charP == '.' ) {
                int take = isMatch(i-1, j, 1, s, p, dp);
                int notTake = isMatch(i, j-1, 0, s, p, dp);
                
                return dp[i][j][star] = (take == 1 || notTake == 1) ? 1 : 0;
            } else 
                return dp[i][j][star] = isMatch(i, j-1, 0, s, p, dp);
        }
        
        if( charS == charP || charP == '.' ) 
            return dp[i][j][star] = isMatch(i-1, j-1, 0, s, p, dp);
        
        if( charP == '*' ) 
            return dp[i][j][star] = isMatch(i, j-1, 1, s, p, dp);
        
        return dp[i][j][star] = 0;
    }
}
*/
