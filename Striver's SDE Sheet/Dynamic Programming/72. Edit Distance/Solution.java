class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] prev = new int[m+1];
        
        for(int j=0; j<=m; j++) 
            prev[j] = j;
        
        for(int i=1; i<=n; i++) {
            int[] curr = new int[m+1];
            curr[0] = i;
            for(int j=1; j<=m; j++) {
                if( word1.charAt(i-1) == word2.charAt(j-1) ) 
                    curr[j] = prev[j-1];
                else 
                    curr[j] = 1 + Math.min(curr[j-1], Math.min(prev[j], prev[j-1]));
            }
            prev = curr;
        }
        return prev[m];
    }
}
/*
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        
        for(int[] states : dp)
            Arrays.fill(states, -1);
        
        return minDist(n-1, m-1, word1, word2, dp);
    }
    
    private int minDist(int i, int j, String word1, String word2, int[][] dp) {
        // if no chars left in word1, j+1 insert will be required to match word1 and word2
        if( i < 0 )
            return j+1;
        
        // if no chars left in word2, i+1 deletions will be required to match word1 and word2
        if( j < 0 )
            return i+1;
        
        if( dp[i][j] != -1 ) return dp[i][j];
        
        if( word1.charAt(i) == word2.charAt(j) ) 
            return dp[i][j] = minDist(i-1, j-1, word1, word2, dp);
        
        int insert = minDist(i, j-1, word1, word2, dp);
        int delete = minDist(i-1, j, word1, word2, dp);
        int replace = minDist(i-1, j-1, word1, word2, dp);
        
        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}
*/
