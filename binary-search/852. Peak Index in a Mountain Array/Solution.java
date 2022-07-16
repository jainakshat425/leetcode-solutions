class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        
        while( lo < hi ) {
            int mid = lo + (hi - lo)/2;
            
            if( arr[mid] < arr[mid+1] )
                lo = mid+1;
            else 
                hi = mid;
        }
        return lo;
    }
}
// class Solution {
//     public int peakIndexInMountainArray(int[] arr) {
//         int n = arr.length;
//         int lo = 0, hi = n-1;
        
//         while( lo <= hi ) {
//             int mid = lo + (hi - lo)/2;
            
//             if( mid == 0 )
//                 lo = mid+1;
//             else if( mid == n-1 )
//                 hi = mid-1;
//             else if( arr[mid] > arr[mid-1] )
//                 if( arr[mid] > arr[mid+1] )
//                     return mid;
//                 else
//                     lo = mid+1;
//             else 
//                 hi = mid-1;
//         }
//         return -1;
//     }
// }
