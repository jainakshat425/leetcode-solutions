class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        Set<String> words = new HashSet();
        for(String word : wordDict)
            words.add( word );
        
        for(int end=1; end<=n; end++) {
            for(int i=end-1; i>=0; i--) {
                if( words.contains( s.substring(i, end) ) && dp[i] ) {
                    dp[end] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
    
    private int wordBreak(int end, String s, Set<String> words, int[] dp) {
        if( end == 0 )
            return 1;
        
        if( dp[end] != 0 ) return dp[end];
        
        for(int i=end-1; i>=0; i--) {
            if( words.contains( s.substring(i, end) ) ) {
                if( wordBreak(i, s, words, dp) == 1 )
                    return dp[end] = 1;
            }
        }
        return dp[end] = -1;
    }
}
