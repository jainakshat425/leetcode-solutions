public class Solution {
    public int findMedian(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        int req = (m*n)/2;

        for(int i=0; i<m; i++) {
            lo = Math.min(lo, A[i][0]);
            hi = Math.max(hi, A[i][n-1]);
        }

        while( lo <= hi ) {
            int mid = lo + (hi-lo)/2;

            int count = 0;
            for(int i=0; i<m; i++) 
                count += countLtEqTo(A[i], mid);

            if( count <= req )
                lo = mid+1;
            else
                hi = mid-1;
        }
        return lo;
    }

    private int countLtEqTo(int[] arr, int num) {
        int lo = 0, hi = arr.length-1;

        while( lo <= hi ) {
            int mid = lo + (hi-lo)/2;

            if( arr[mid] <= num )
                lo = mid+1;
            else
                hi = mid-1;
        }
        return lo;
    }
}
