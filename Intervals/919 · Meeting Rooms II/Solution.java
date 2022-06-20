/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if( n == 0 )
            return 0;

        int[] start = new int[n];
        int[] end = new int[n];

        for(int i=0; i<n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int ans = 0;
        int rooms = 0;

        int j=0;
        for(int i=0; i<n; i++) {
            // For new meeting, allocate a new room
            rooms++;
            // Empty rooms where meetings end till current start time
            while( end[j] <= start[i] ) {
                rooms--;
                j++;
            }
            ans = Math.max(ans, rooms);
        }
        return ans;
    }
}
