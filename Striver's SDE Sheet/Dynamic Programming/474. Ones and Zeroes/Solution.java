class Solution {
    public int findMaxForm(String[] strs, int maxZero, int maxOne) {
        int n = strs.length;
        int[][] dp = new int[maxZero+1][maxOne+1];
                    
        for(String str : strs) {
            int[] counts = getCounts(str);
            
            for(int zero=maxZero; zero>=0; zero--) {
                for(int one=maxOne; one>=0; one--) {
                    
                    int notTake = dp[zero][one];
                    
                    int take = 0;
                    if( counts[0] <= zero && counts[1] <= one ) 
                        take = 1 + dp[ zero-counts[0] ][ one-counts[1] ];

                    dp[zero][one] = Math.max(take, notTake);
                }
            }
        }
        return dp[maxZero][maxOne];
    }
    
    private int[] getCounts(String str) {
        int n = str.length();
        int[] counts = new int[2];
        
        for(int j=0; j<n; j++) 
            counts[str.charAt(j)-'0']++;
        
        return counts;
    }
    /*
    public int findMaxForm(String[] strs, int maxZero, int maxOne) {
        int n = strs.length;
        int[][] prev = new int[maxZero+1][maxOne+1];
                    
        for(int i=0; i<n; i++) {
            int[][] curr = new int[maxZero+1][maxOne+1];
            
            int[] counts = new int[2];
            for(int j=0; j<strs[i].length(); j++) 
                counts[strs[i].charAt(j)-'0']++;
            
            for(int zero=0; zero<=maxZero; zero++) {
                for(int one=0; one<=maxOne; one++) {
                    
                    int notTake = 0;
                    if( i > 0 )
                        notTake = prev[zero][one];
                    
                    int take = 0;
                    if( counts[0] <= zero && counts[1] <= one ) {
                        take = 1; 
                        if( i > 0 )
                            take += prev[ zero-counts[0] ][ one-counts[1] ];
                    }

                    curr[zero][one] = Math.max(take, notTake);
                }
            }
            prev = curr;
        }
        return prev[maxZero][maxOne];
    }
    
    private int findMax(int i, int zero, int one, int[][] counts, int[][][] dp) {
        if( i < 0 || (zero == 0 && one == 0))
            return 0;
        
        if( dp[i][zero][one] != -1 ) return dp[i][zero][one];
        
        int notTake = findMax(i-1, zero, one, counts, dp);
        
        int take = 0;
        if( counts[i][0] <= zero && counts[i][1] <= one )
            take = 1 + findMax(i-1, zero - counts[i][0], one - counts[i][1], counts, dp);
        
        return dp[i][zero][one] = Math.max(take, notTake);
    }
    */
}
