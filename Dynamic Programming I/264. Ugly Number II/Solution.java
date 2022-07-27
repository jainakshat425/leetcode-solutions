class Solution {
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        
        for(int i=1; i<n; i++) {
            int twoX =   dp[p2] * 2;
            int threeX = dp[p3] * 3;
            int fiveX =  dp[p5] * 5;
            
            dp[i] = Math.min(twoX, Math.min(threeX, fiveX));
            
            if( dp[i] == twoX )   p2++;
            if( dp[i] == threeX ) p3++;
            if( dp[i] == fiveX )  p5++;
        }
        return dp[n-1];
    }
}
