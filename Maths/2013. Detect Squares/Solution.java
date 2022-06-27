class DetectSquares {

    private Map<Integer,Map<Integer,Integer>> pointCounts;
        
    public DetectSquares() {
        pointCounts = new HashMap();
    }
    
    public void add(int[] point) {
        Map<Integer,Integer> pntCount = pointCounts.getOrDefault(point[0], new HashMap());
        pntCount.put(point[1], pntCount.getOrDefault(point[1], 0) + 1);
        pointCounts.put(point[0], pntCount);
    }
    
    public int count(int[] point) {
        int ans = 0;
        
        for(int x : pointCounts.keySet()) {
            Map<Integer,Integer> pntCount = pointCounts.get(x);
            
            for(int y : pntCount.keySet()) {
                
                if( x == point[0] || y == point[1] ||  (Math.abs(x-point[0]) != Math.abs(y-point[1])) )
                    continue;
                   
                ans += pntCount.get(y) * getCount(point[0], y) * getCount(x, point[1]);
            }
        }
        return ans;
    }
    
    private int getCount(int x, int y) {
        if( !pointCounts.containsKey(x) )
            return 0;
        return pointCounts.get(x).getOrDefault(y, 0);
    }
                   
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
