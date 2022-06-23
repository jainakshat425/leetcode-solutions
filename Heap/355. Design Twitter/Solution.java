class Twitter {
    // 0 > tweetId, 1 > timestamp
    private Map<Integer,List<int[]>> userTweets;
    private Map<Integer,Set<Integer>> userFollowings;
    private int timer;

    public Twitter() {
        userTweets = new HashMap();
        userFollowings = new HashMap();
        timer = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> tweets;
        
        if( !userTweets.containsKey(userId) ) 
            userTweets.put(userId, new ArrayList());
        
        userTweets.get(userId).add(new int[]{ tweetId, ++timer });
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> recentTweets = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        
        getRecent10Tweets(userId, recentTweets);
        
        if( userFollowings.containsKey(userId) ) {
            for(int followeeId : userFollowings.get(userId)) 
                getRecent10Tweets(followeeId, recentTweets);
        }
        
        List<Integer> ans = new ArrayList(recentTweets.size());
        while( !recentTweets.isEmpty() )
            ans.add(0, recentTweets.poll()[0] );
        
        return ans;
    }
    
    private void getRecent10Tweets(int userId, PriorityQueue<int[]> recentTweets) {
        if( !userTweets.containsKey(userId) )
            return;
        
        List<int[]> tweets = userTweets.get(userId);
        int n = tweets.size();
        int end = Math.max(n - 10, 0);
        

        // Get last 10 tweets of current user
        for(int i=n-1; i>=end; i--) {

            if( recentTweets.size() < 10 || recentTweets.peek()[1] < tweets.get(i)[1] ) {
                recentTweets.offer( tweets.get(i) );

                if( recentTweets.size() > 10 )
                    recentTweets.poll();
            } 
            // all the tweets are older
            else break;
        }
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followeeIds;
        
        if( !userFollowings.containsKey(followerId) )
            userFollowings.put(followerId, new HashSet());
        
        userFollowings.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {        
        if( userFollowings.containsKey(followerId) ) 
            userFollowings.get(followerId).remove(followeeId);        
    }
}
/* 
class Twitter {
    // 0 > tweetId, 1 > timestamp
    private Map<Integer,PriorityQueue<int[]>> userTweets;
    private Map<Integer,Set<Integer>> userFollowings;
    private int timer;

    public Twitter() {
        userTweets = new HashMap();
        userFollowings = new HashMap();
        timer = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        PriorityQueue<int[]> tweets;
        
        if( !userTweets.containsKey(userId) ) 
            userTweets.put(userId, new PriorityQueue<int[]>((a,b) -> b[1] - a[1]));
        
        userTweets.get(userId).offer(new int[]{ tweetId, ++timer });
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> recentTweets = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        
        getRecent10Tweets(userId, recentTweets);
        
        if( userFollowings.containsKey(userId) ) {
            for(int followeeId : userFollowings.get(userId)) 
                getRecent10Tweets(followeeId, recentTweets);
        }
        
        List<Integer> ans = new ArrayList(recentTweets.size());
        while( !recentTweets.isEmpty() )
            ans.add(0, recentTweets.poll()[0] );
        
        return ans;
    }
    
    private void getRecent10Tweets(int userId, PriorityQueue<int[]> recentTweets) {
        if( !userTweets.containsKey(userId) )
            return;
        
        // Removed tweets
        List<int[]> last10Tweets = new ArrayList();
        PriorityQueue<int[]> tweets = userTweets.get(userId);

        // Get last 10 tweets of current user
        for(int i=0; i<10 && !tweets.isEmpty(); i++) {

            if( recentTweets.size() < 10 || recentTweets.peek()[1] < tweets.peek()[1] ) {
                int[] tweet = tweets.poll();
                recentTweets.offer( tweet );
                last10Tweets.add( tweet );

                if( recentTweets.size() > 10 )
                    recentTweets.poll();
            } 
            // all the tweets are older
            else break;
        }
        // Put back tweets in tweets map
        for(int[] tweet : last10Tweets) 
            tweets.offer( tweet );
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followeeIds;
        
        if( !userFollowings.containsKey(followerId) )
            userFollowings.put(followerId, new HashSet());
        
        userFollowings.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {        
        if( userFollowings.containsKey(followerId) ) 
            userFollowings.get(followerId).remove(followeeId);        
    }
}

*/
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
