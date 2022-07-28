class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double low = (double)arr[0]/arr[n-1], high = 1;
        
        while( low < high ) {
            double mid = (low + high) / 2.0;
            
            // {count, numerator, denominator}
            int[] count = countSmallerFractions(mid, arr);
            
            if( count[0] == k )
                return new int[]{count[1], count[2]};
            else if( count[0] < k )
                low = mid;
            else
                high = mid;
        }
        return null;
    }
    
    private int[] countSmallerFractions(double target, int[] arr) {
        int n = arr.length;
        int i=0; 
        int count = 0;
        int num = arr[0], deno = arr[n-1];
        
        for(int j=1; j<n; j++) {
            
            while( arr[i] <= target * arr[j] )
                i++;
            
            count += i;
            
            if( i > 0 && arr[i-1] * deno > num * arr[j] ) {
                num = arr[i-1];
                deno = arr[j];
            }
        }
        return new int[]{ count, num, deno };
    }
}
// class Solution {
//     public int[] kthSmallestPrimeFraction(int[] arr, int k) {
//         int n = arr.length;
//         Comparator<int[]> fractionComparator = (a, b) -> {
//             // xi is numerator and yi is denominator
//             int x1 = arr[a[0]], y1 = arr[a[1]];
//             int x2 = arr[b[0]], y2 = arr[b[1]];
//             // due to precision error in divison, use multiplication instead
//             return Integer.compare(x1*y2, x2*y1);
//         };
//         PriorityQueue<int[]> pq = new PriorityQueue(fractionComparator);
        
//         for(int i=0; i<Math.min(n,k); i++)
//             pq.offer(new int[]{i, n-1});
        
//         while( --k > 0 ) {
//             int x1 = pq.peek()[0];
//             int y1 = pq.peek()[1];
//             pq.poll();
            
//             if( y1-1 > x1 )
//                 pq.offer(new int[]{x1, y1-1});
//         }
        
//         int[] ans = pq.poll();
//         return new int[]{arr[ans[0]], arr[ans[1]]};
//     }
// }
