class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp = new int[N][N];
        
        for(int start=N-3; start>=0; start--) {
            for(int end=start+2; end<N; end++) {
                int min = Integer.MAX_VALUE;
                for(int p=start+1; p<end; p++) {
                    int multiplications = arr[start] * arr[p] * arr[end] 
                        + dp[start][p]
                        + dp[p][end];
                        
                    min = Math.min(min, multiplications);
                }
                dp[start][end] = min;
            }
        }
        
        return dp[0][N-1];
    }
    
    // static int matrixMultiplication(int start, int end, int[] arr, int[][] dp) {
        
    //     if( start >= (end-1) )
    //         return 0;
            
    //     if( dp[start][end] != -1 ) return dp[start][end];
        
    //     int min = Integer.MAX_VALUE;
    //     for(int p=start+1; p<end; p++) {
    //         int multiplications = arr[start] * arr[p] * arr[end] 
    //             + matrixMultiplication(start, p, arr, dp)
    //             + matrixMultiplication(p, end, arr, dp);
                
    //         min = Math.min(min, multiplications);
    //     }
    //     return dp[start][end] = min;
    // }
}
