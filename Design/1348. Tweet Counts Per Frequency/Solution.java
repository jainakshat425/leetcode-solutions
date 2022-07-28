class TweetCounts {

    private Map<String,TreeMap<Integer,Integer>> count;
    
    public TweetCounts() {
        count = new HashMap();
    }
    
    public void recordTweet(String tweetName, int time) {        
        count.putIfAbsent(tweetName, new TreeMap());
        
        TreeMap<Integer,Integer> timeToCount = count.get(tweetName);
        timeToCount.put(time, timeToCount.getOrDefault(time, 0) + 1);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int interval = 86400;
        
        if( freq.equals("minute") )
            interval = 60;
        else if( freq.equals("hour") )
            interval = 3600;
        
        int size = (endTime-startTime)/interval + 1;
        
        List<Integer> ans = new ArrayList();
        
        for(int i=0; i<size; i++)
            ans.add(0);
        
        Set<Map.Entry<Integer,Integer>> entries = 
            count.get(tweetName).subMap(startTime,endTime+1).entrySet();

        for(Map.Entry<Integer,Integer> entry : entries) {
            int chunkInd = (entry.getKey() - startTime) / interval;
            ans.set(chunkInd, ans.get(chunkInd) + entry.getValue());
        }
        return ans;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */

