class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // Apply binary to first column of the matrix and get the row in which target should exist
        // If such row is found apply binary search to that row
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Apply binary to first column of the matrix
        // {row} is index of the row, in which {target} should exist
        int row = columnBinarySearch(matrix, 0, m-1, target);
        
        // If there is no such row, return false
        if( row == -1 ) return false;
        
        // Apply binary search to the single row found above
        return binarySearch(matrix[row], 0, n-1, target) != -1;
    }
    
    private int columnBinarySearch(int[][] matrix, int start, int end, int target) {
        if( start > end ) return -1;
        
        int mid = start + (end-start)/2;
        int lastCol = matrix[0].length-1;
        
        // Return mid, if target lies between the range of the current row
        if( matrix[mid][0] <= target && target <= matrix[mid][lastCol] ) {
            return mid;
        } 
        // Search in upper half if the target is smaller than mid
        else if( matrix[mid][0] > target) {
            return columnBinarySearch(matrix, start, mid-1, target);
        } 
        // Search in upper half if the target is greater than mid
        else {
            return columnBinarySearch(matrix, mid+1, end, target);
        }
    }
    
    private int binarySearch(int[] arr, int start, int end, int target) {
        if( start > end ) return -1;
        
        int mid = start + (end-start)/2;
        
        if( arr[mid] == target ) {
            return start;
        } else if( arr[mid] < target ) {
            return binarySearch(arr, mid+1, end, target);
        } else {
            return binarySearch(arr, start, mid-1, target);
        }
    }
    
}
