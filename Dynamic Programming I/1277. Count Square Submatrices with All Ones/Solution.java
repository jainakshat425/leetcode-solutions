class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ans = 0;
        
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                
                if( i != m-1 && j != n-1 && matrix[i][j] == 1 )
                    matrix[i][j] = 1 + Math.min(
                        matrix[i+1][j+1], 
                        Math.min(matrix[i+1][j], matrix[i][j+1])
                    );
                    
                ans += matrix[i][j];
            }
        }
        return ans;
    }
}
