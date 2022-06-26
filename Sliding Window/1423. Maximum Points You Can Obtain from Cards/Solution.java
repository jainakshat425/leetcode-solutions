class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = Arrays.stream(cardPoints).sum();
        
        int excludeLen = n-k;
        
        if( excludeLen == 0 )
            return total;
        
        int left = 0;
        int sum = 0;
        int min = total;
        
        for(int right=0; right < n; right++) {
            sum += cardPoints[right];
            
            int len = right-left+1;
            
            if( len == excludeLen ) {
                min = Math.min(min, sum);
                sum -= cardPoints[left++];
            }
        }
        return total-min;
    }
    
}

/* TLE and MLE
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[][] dp = new int[k][k];
        for(int[] state : dp)
            Arrays.fill(state, -1);
        return maxScore(0, n-1, k, cardPoints, dp);
    }
    
    private int maxScore(int left, int right, int k, int[] cardPoints, int[][] dp) {
        int n = cardPoints.length;
        
        if( k == 0 )
            return 0;
        
        if( dp[left][n-1-right] != -1 )
            return dp[left][n-1-right];
        
        int scoreLeft = cardPoints[left] + maxScore(left+1, right, k-1, cardPoints, dp);
        int scoreRight = cardPoints[right] + maxScore(left, right-1, k-1, cardPoints, dp);
        
        return dp[left][n-1-right] = Math.max(scoreLeft, scoreRight);
    }
}
*/
