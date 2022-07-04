class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sqlen = new int[m][n];
        int maxlen = 0;
                
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                
                if( i == m-1 || j == n-1 )
                    sqlen[i][j] = matrix[i][j] - '0';
                
                else if( matrix[i][j] == '1' )
                    sqlen[i][j] = 1 + Math.min(sqlen[i][j+1], Math.min(sqlen[i+1][j], sqlen[i+1][j+1]));
                
                maxlen = Math.max(maxlen, sqlen[i][j]);
            }
        }
        return maxlen * maxlen;
    }
}
