class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<Meeting> meetings = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            meetings.add( new Meeting( start[i], end[i]) );
        }
        
        // Sort the meetings in the ascending order of there end time
        Collections.sort( meetings );
        
        int count = 0;
        
        // End time of the last meeting, next meeting should start after this
        int endTime = -1;
        
        for(Meeting meeting : meetings) {
            // If current meeting starts after the previous meeting has ended
            if( meeting.start > endTime ) {
                // Count the current meeting in
                count++;
                
                // Update the last meeting end time
                endTime = meeting.end;
            }
        }
        return count;
    }
}
class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int compareTo(Meeting m2) {
        return this.end - m2.end;
    }
}
