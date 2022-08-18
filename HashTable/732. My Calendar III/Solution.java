class MyCalendarThree {
    
    private TreeMap<Integer,Integer> count;

    public MyCalendarThree() {
        count = new TreeMap();
    }
    
    public int book(int start, int end) {
        count.put(start, count.getOrDefault(start, 0) + 1);
        count.put(end, count.getOrDefault(end, 0) - 1);
        
        int k = 0, sum = 0;
        
        for(int time : count.keySet()) {
            int cnt = count.get(time);
            sum += cnt;
            
            k = Math.max(k, sum);
        }
        return k;
    }
}
/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
