class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        
        for(int k=0; k<n; k++) {
            
            for(int i=0; i<n; i++) {
                if( i == k )
                    continue;
                    
                for(int j=0; j<n; j++) {
                    if( i == j || j == k || matrix[i][k] == -1 || matrix[k][j] == -1 )
                        continue;
                    else if( matrix[i][j] == -1 )
                        matrix[i][j] = Integer.MAX_VALUE;
                        
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
    }
}
