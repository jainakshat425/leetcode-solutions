class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] prev = new int[n+1];
        
        for(int j=1; j<=n; j++)
            prev[j] = j;
        
        for(int i=1; i<=m; i++) {
            int[] curr = new int[n+1];
            curr[0] = i;
            for(int j=1; j<=n; j++) {
                if( word1.charAt(i-1) == word2.charAt(j-1) )
                    curr[j] = prev[j-1];
                else
                    curr[j] = 1 + Math.min(prev[j], curr[j-1]);
            }
            prev = curr;
        }
        return prev[n];
    }
}
/*
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return minDist(m-1, n-1, word1, word2);
    }
    
    private int minDist(int i, int j, String word1, String word2) {
        if( i == -1 && j == -1 ) return 0;
        if( i == -1 ) return j+1;
        if( j == -1 ) return i+1;
        
        if( word1.charAt(i) == word2.charAt(j) )
            return minDist(i-1, j-1, word1, word2);
        
        return 1 + Math.min(minDist(i-1, j, word1, word2), minDist(i, j-1, word1, word2));
    }
}
*/
