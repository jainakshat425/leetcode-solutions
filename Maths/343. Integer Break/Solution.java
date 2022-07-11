class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        return intBreak(n, n, dp);
    }
    
    private int intBreak(int num, int n, int[] dp) {
        if( n == 1 )
            return 1;
        
        if( dp[num] != 0 ) return dp[num];
        
        int max = num == n ? 0 : num;
        for(int i=1; i<num; i++) {
            int breakNum = intBreak(num-i, n, dp);
            int dontBreak = intBreak(i, n, dp);
            max = Math.max(max, breakNum * dontBreak);
        }
        
        return dp[num] = max;
    }
}
