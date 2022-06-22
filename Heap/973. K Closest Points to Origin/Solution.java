class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        if( k == n )
            return points;
        
        quickSelect(0, n-1, points, k);
        
        return Arrays.copyOf(points, k);
    }
    
    private void quickSelect(int left, int right, int[][] points, int k) {
        int pivot = squaredDistance(points[right]);
        int p = left;
        
        for(int i=left; i<right; i++) {
            if( squaredDistance(points[i]) <= pivot )
                swap(i, p++, points);
        }
        swap(p, right, points);
        
        if( p < k ) 
             quickSelect(p+1, right, points, k);
        else if( p > k ) 
             quickSelect(left, p-1, points, k);
    }
    
    private void swap(int i, int j, int[][] arr) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private int squaredDistance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}
// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         int n = points.length;
//         if( k == n )
//             return points;
        
//         // 0 > squared distance, 1 > index of point in points array
//         PriorityQueue<int[]> pqueue = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        
//         for(int i=0; i<n; i++) {
//             int sqDist = squaredDistance( points[i] );
            
//             if( pqueue.size() < k )
//                 pqueue.offer( new int[]{sqDist, i} );
            
//             else if( sqDist < pqueue.peek()[0] ) {
//                 pqueue.poll();
//                 pqueue.offer(new int[]{sqDist, i});
//             }
//         }
        
//         int[][] ans = new int[k][2];
//         for(int i=0; i<k; i++) 
//             ans[i] = points[pqueue.poll()[1]];
        
//         return ans;
//     }
    
//     private int squaredDistance(int[] point) {
//         return point[0]*point[0] + point[1]*point[1];
//     }
// }
