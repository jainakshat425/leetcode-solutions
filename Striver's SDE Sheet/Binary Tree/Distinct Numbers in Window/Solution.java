public class Solution {
    public int[] dNums(int[] A, int B) {
        int n = A.length;

        if( B > n )
            return new int[]{};

        int[] ans = new int[n-B+1];
        Map<Integer,Integer> distinctCountMap = new HashMap();

        for(int i=0; i<n; i++) {
            /* After crossing the first window at (B-1), decrement the count of the 
            number which just left the window */
            if( i >= B )
                decrementCount(distinctCountMap, A[i-B]);

            // Increment the count of the number which just got added to the window
            incrementCount(distinctCountMap, A[i]);

            // Start updating the ans once reached end of the first window (B-1)
            if( i >= B-1 )
                ans[i-B+1] = distinctCountMap.size();
        }
        return ans;
    }

    private void incrementCount(Map<Integer,Integer> map, int num) {
        int count = map.getOrDefault(num, 0);
        map.put(num, count+1);
    }

    private void decrementCount(Map<Integer,Integer> map, int num) {
        int count = map.get(num);
        if( count == 1 ) 
            map.remove( num );
        else 
            map.put( num, count-1 );
    }
}
