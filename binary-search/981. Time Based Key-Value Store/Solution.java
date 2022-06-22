class TimeMap {
    private Map<String,List<Pair>> map;
    
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList());
        list.add(new Pair(value, timestamp));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if( list == null )
            return "";
        
        int low = 0, high = list.size()-1;
        int ind = -1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            int timestamp_prev  = list.get(mid).timestamp;
            
            if( timestamp_prev == timestamp ) {
                ind = mid;
                break;
            } else if( timestamp_prev < timestamp ) {
                ind = mid;
                low = mid+1;
            } else
                high = mid-1;
        }
        return ind != -1 ? list.get(ind).value : "";
    }
    
    class Pair implements Comparable<Pair> {
        public String value;
        public int timestamp;
        
        public Pair(String val, int ts) {
            value = val;
            timestamp = ts;
        }
        
        @Override
        public int compareTo(Pair b) {
            return timestamp - b.timestamp;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
