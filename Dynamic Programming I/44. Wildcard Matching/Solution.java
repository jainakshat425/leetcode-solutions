class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[] prev = new boolean[m+1];
        prev[0] = true;
        
        for(int j=1; j<=m; j++) {
            int tempJ = j;
            prev[j] = true;
            while( tempJ > 0 ) {
                if( p.charAt(tempJ-1) != '*' ) {
                    prev[j] = false;
                    break;
                }
                tempJ--;
            }
        }
        
        for(int i=1; i<=n; i++) {
            boolean[] curr = new boolean[m+1];
            for(int j=1; j<=m; j++) {
                char sc = s.charAt(i-1), pc = p.charAt(j-1);
        
                if( pc  == '?' || sc == pc )
                    curr[j] = prev[j-1];

                else if( pc == '*' ) 
                    curr[j] = curr[j-1] || prev[j];

                else curr[j] = false;
            }
            prev = curr;
        }
        return prev[m];
    }
}
/*
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        
        for(int i=1; i<=n; i++)
            dp[i][0] = false;
        
        for(int j=1; j<=m; j++) {
            int tempJ = j;
            dp[0][j] = true;
            while( tempJ > 0 ) {
                if( p.charAt(tempJ-1) != '*' ) {
                    dp[0][j] = false;
                    break;
                }
                tempJ--;
            }
        }
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                char sc = s.charAt(i-1), pc = p.charAt(j-1);
        
                if( pc  == '?' || sc == pc )
                    dp[i][j] = dp[i-1][j-1];

                else if( pc == '*' ) 
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];

                else dp[i][j] = false;
            }
        }
        return dp[n][m];
    }
}*/
/*
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        
        return isMatch(n-1, m-1, s, p, dp) == 1;
    }
    
    private int isMatch(int i, int j, String s, String p, int[][] dp) {
        if( i < 0 && j < 0 )
            return 1;
        if( j < 0 )
            return -1;
        if( i < 0 ) {
            while( j >= 0 ) {
                if( p.charAt(j) != '*' )
                    return -1;
                j--;
            }
            return 1;
        }
        
        if( dp[i][j] != 0 ) return dp[i][j];
        
        char sc = s.charAt(i), pc = p.charAt(j);
        
        if( pc  == '?' || sc == pc )
            return dp[i][j] = isMatch(i-1, j-1, s, p, dp);
        
        if( pc == '*' ) {
            
            int notTake = isMatch(i, j-1, s, p, dp);
            
            if( notTake == 1 )
                return dp[i][j] = 1;
            
            int take = isMatch(i-1, j, s, p, dp);
            
            return dp[i][j] = take;
        } 
        
        return dp[i][j] = -1;
    }
}
*/
