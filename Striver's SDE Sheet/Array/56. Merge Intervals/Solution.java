class Solution {
    
    private static final int INTERVAL_START = 0;
    private static final int INTERVAL_END = 1;
    
    public int[][] merge(int[][] intervals) {
        /* 
        To check if two intervals overlap, we just need to check if the next interval start before previous interval ends.
        i.e. next interval's start <= previous interval's end

        For this to work, the intervals must be sorted in the increasing order of there start point.

        After the intervals are sorted, we can iterate over each interval and check if next interval's start <= previous interval's end, then we can merge this overlapping intervals. Otherwise, take the interval as it is.

        Time Complexity = O(nlogn) for sorting + O(n) for checking and merging intervals = O(nlogn)
        Space Complexity = O(n) for storing the result
        */
        
        // Sort the intervals in the increasing order of the interval start.
        Arrays.sort(
            intervals, 
            (i1, i2) -> Integer.compare(i1[INTERVAL_START], i2[INTERVAL_START])
        );
        
        int n = intervals.length;
        
        List<int[]> result = new ArrayList<int[]>();
        
        // Last interval which has been added to the result list
        int[] prev = intervals[0];
        result.add( prev );
        
        // Iterate from second interval till the last interval
        for(int i=1; i<n; i++) {
                        
            int[] curr = intervals[i];
            
            // If previous interval's end is greater than equal to current interval's start, then current interval overlaps with the previous interval
            if( prev[INTERVAL_END] >= curr[INTERVAL_START] ) {
                   
                // If previous interval is not completely overlapping the current interval
                if( curr[INTERVAL_END] > prev[INTERVAL_END] ) {
                    // Extend previous interval till the current interval's end
                    prev[INTERVAL_END] = curr[INTERVAL_END];
                }                
            } 
            // Interval do not overlap, add the new interval to the list
            else {
                // Update last interval which has been added to the result list
                prev = curr;
                
                result.add( curr );
            }
        }
        
        // Get the count of total intervals in the result
        int newSize = result.size();
        
        // Convert the result list to an array
        return result.toArray( new int[newSize][] );
    }
}
