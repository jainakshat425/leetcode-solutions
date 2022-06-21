class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l=0, r=n-1;
        int t=0, b=n-1;
        
        while( l < r ) {
            for(int i=0; i<r-l; i++) {
                // backup top-left
                int topLeft = matrix[t][l+i];

                // copy bottom-left into top-left
                matrix[t][l+i] = matrix[b-i][l];

                // copy bottom-right into bottom-left
                matrix[b-i][l] = matrix[b][r-i];

                // copy top-right into bottom-right
                matrix[b][r-i] = matrix[t+i][r];

                // copy top-left into top-right
                matrix[t+i][r] = topLeft;
            }
            l++;
            r--;
            t++;
            b--;
        }
    }
}
