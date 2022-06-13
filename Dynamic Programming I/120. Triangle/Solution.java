class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m];
        
        for(int col=0; col<m; col++)
            dp[col] = triangle.get(m-1).get(col);
        
        for(int row=m-2; row>=0; row--) {
            for(int col=0; col<=row; col++) 
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col+1]);
        }
        
        return dp[0];
    }
}
/*
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        return minTotal(0, 0, m, 1, triangle);
    }
    
    private int minTotal(int row, int col, int m, int n, List<List<Integer>> triangle) {
        int val = triangle.get(row).get(col);
        
        if( row == m-1 )
            return val;
        
        int val1 = minTotal(row+1, col, m, n+1, triangle);
        int val2 = minTotal(row+1, col+1, m, n+1, triangle);
        
        return val + Math.min(val1, val2);
    }
}
*/
