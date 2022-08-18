class MyCalendarTwo {

    private TreeMap<Integer,Integer> count;
    
    public MyCalendarTwo() {
        count = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        int startCnt = count.getOrDefault(start, 0);
        int endCnt = count.getOrDefault(end, 0);
        
        count.put(start, startCnt + 1);
        count.put(end, endCnt - 1);
        
        int sum = 0;
        
        for(int time : count.keySet()) {
            int cnt = count.get(time);
            sum += cnt;
            
            if( sum >= 3 ) {
                if( startCnt == 0 )
                    count.remove(start);
                else
                    count.put(start, startCnt);
                count.put(end, endCnt);
                return false;
            }
            
            if( cnt > 0 && time > end )
                break;
        }
        return true;
    }
}
// class MyCalendarTwo {

//     private List<int[]> events;
//     private TreeMap<Integer,Integer> doubleBook;
    
//     public MyCalendarTwo() {
//         events = new ArrayList();
//         doubleBook = new TreeMap();
//     }
    
//     public boolean book(int start, int end) {
//         Integer next = doubleBook.ceilingKey(start), 
//             prev = doubleBook.floorKey(start);
        
//         if( prev != null && doubleBook.get(prev) > start )
//             return false;
//         if( next != null && next < end )
//             return false;
        
//         for(int[] e : events) 
//             if( start < e[1] && end > e[0] ) 
//                 doubleBook.put(Math.max(start,e[0]), Math.min(end,e[1]));

//         events.add( new int[]{start, end} );
//         return true;
//     }
// }


/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
