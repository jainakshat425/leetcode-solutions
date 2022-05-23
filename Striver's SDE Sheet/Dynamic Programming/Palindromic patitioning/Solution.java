class Solution{
    static int palindromicPartition(String str)
    {
        int n = str.length();
        int[][] dp = new int[n+1][n];
            
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {

                int min = Integer.MAX_VALUE;
                
                for(int ind=i; ind<=j; ind++) {
                    if( isPalindrome(i, ind, str) ) 
                        min = Math.min(min, 1 + dp[ind+1][j]);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][n-1] - 1;
    }
    /*
    static int partition(int i, int j, String str, int[][] dp) {
        if( i > j )
            return 0;
           
        if( dp[i][j] != -1 ) 
            return dp[i][j];
            
        int min = Integer.MAX_VALUE;
        for(int ind=i; ind<=j; ind++) {
            
            if( isPalindrome(i, ind, str) ) 
                min = Math.min(min, 1 + partition(ind+1, j, str, dp));
        }
        return dp[i][j] = min;
    }
    */
    static boolean isPalindrome(int i, int j, String str) {
        while( i < j ) {
            if( str.charAt(i) != str.charAt(j) )
                return false;
            i++;
            j--;
        }
        return true;
    }
}
