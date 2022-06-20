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
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        if( intervals.size() == 0 )
            return true;

        Collections.sort(intervals, (a,b) -> a.start - b.start);
        int end = intervals.get(0).end;

        for(int i=1; i<intervals.size(); i++) {
            if( intervals.get(i).start < end )
                return false;
            end = intervals.get(i).end;
        }
        return true;
    }
}
