class MyCalendar {
    
    // [start, end)
    private TreeMap<Integer,Integer> events;
    
    public MyCalendar() {
        events = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = events.floorKey(start),
            next = events.ceilingKey(start);
        
        if( prev != null && events.get(prev) > start ) 
            return false;
        
        if( next != null && next < end )
            return false;

        events.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
