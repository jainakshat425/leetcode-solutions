class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        
        for(int i=n1-1; i>=0; i--)
            dp[i][n2] = s1.charAt(i) + dp[i+1][n2];
        
        for(int j=n2-1; j>=0; j--)
            dp[n1][j] = s2.charAt(j) + dp[n1][j+1];
        
        for(int i=n1-1; i>=0; i--) {
            for(int j=n2-1; j>=0; j--) {
                char c1 = s1.charAt(i), c2 = s2.charAt(j);

                if(  c1 == c2 )
                    dp[i][j] = dp[i+1][j+1];
                else
                    dp[i][j] = Math.min(c1 + dp[i+1][j], c2 + dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
// class Solution {
//     public int minimumDeleteSum(String s1, String s2) {
//         return minDelete(0, 0, s1, s2);
//     }
    
//     private int minDelete(int i, int j, String s1, String s2) {
//         if( i == s1.length() && j == s2.length() )
//             return 0;
        
//         if( i == s1.length() )
//             return asciiSum(j, s2);
        
//         if( j == s2.length() )
//             return asciiSum(i, s1);
        
//         char c1 = s1.charAt(i), c2 = s2.charAt(j);
        
//         if(  c1 == c2 )
//             return minDelete(i+1, j+1, s1, s2);
        
//         int deleteS1 = c1 + minDelete(i+1, j, s1, s2);
//         int deleteS2 = c2 + minDelete(i, j+1, s1, s2);
        
//         return Math.min(deleteS1, deleteS2);
//     }
    
//     private int asciiSum(int i, String s) {
//         int sum = 0;
        
//         while( i < s.length() )
//             sum += s.charAt(i++);
        
//         return sum;
//     }
// }
