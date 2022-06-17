class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        
        for(int i=n-1; i>=0; i--) {
            if( s.charAt(i) == '0' )
                continue;
        
            int pickOne = dp[i+1];
            int pickTwo = 0;
            if( i+1 < n && isValidAlphabet(i, i+1, s))
                pickTwo = dp[i+2];

            dp[i] = pickOne + pickTwo;
        }
        return dp[0];
    }
    
    private boolean isValidAlphabet(int i, int j, String s) {
        return s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(j) < '7');
    }
}
/* 
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        return countWays(0, n, s);
    }
    
    private int countWays(int i, int n, String s) {
        if( i == n )
            return 1;
        if( s.charAt(i) == '0' )
            return 0;
        
        int pickOne = countWays(i+1, n, s);
        int pickTwo = 0;
        if( i+1 < n && Integer.parseInt(s.substring(i, i+2)) <= 26 )
            pickTwo = countWays(i+2, n, s);
        
        return pickOne + pickTwo;
    }
}
*/
