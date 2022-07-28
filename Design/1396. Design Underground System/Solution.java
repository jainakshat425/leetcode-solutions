class UndergroundSystem {

    // User ID -> {Check-in Station, Check-in Time}
    private Map<Integer,Pair<String,Integer>> userCheckIn;
    // Src_Dest -> Average}
    private Map<String,Average> timeTaken;
        
    public UndergroundSystem() {
        userCheckIn = new HashMap();
        timeTaken = new HashMap();
    }
    
    public void checkIn(int id, String stationName, int t) {
        userCheckIn.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String dest, int t) {
        Pair<String,Integer> src = userCheckIn.remove(id);
        
        String srcToDest = src.getKey() + "_" + dest;
        int time = t - src.getValue();
        
        timeTaken.putIfAbsent(srcToDest, new Average());
        timeTaken.get(srcToDest).add( time );
    }
    
    public double getAverageTime(String src, String dest) {
        return timeTaken.get(src + "_" + dest).getAverage();
    }
    
    class Average {
        public int sum;
        public int count;
        
        public Average() {
            this.sum = 0;
            this.count = 0;
        }
        
        public void add(int val) {
            sum += val;
            count++;
        }
        
        public double getAverage() {
            return (double)sum/count;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
