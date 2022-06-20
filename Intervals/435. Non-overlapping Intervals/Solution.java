class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int ans = 0;
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int end = intervals[0][1];
        
        for(int i=1; i<n; i++) {
            if( intervals[i][0] < end ) {
                ans++;
                end = Math.min(intervals[i][1], end );
            } else 
                end = intervals[i][1];
        }
        return ans;
    }
}
