class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n-1][n-1];
        int ans = -1;
        
        while(left <= right) {
            int mid = left + (right-left)/2;
            
            if( countLessOrEqual(mid, n, matrix) >= k ) {
                ans = mid;
                right = mid-1;
            } else
                left = mid+1;
        }
        return ans;
    }
    
    private int countLessOrEqual(int num, int n, int[][] matrix) {
        int count = 0;
        for(int i=0; i<n; i++) {
            int j = n-1;
            while(j >= 0 && num < matrix[i][j])
                j--;
                
            if( j < 0 )
                break;
            
            count += j+1;
        }
        return count;
    }
}
