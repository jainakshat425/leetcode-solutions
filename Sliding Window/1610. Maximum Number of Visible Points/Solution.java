class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList();
        int ans = 0;
        
        for(List<Integer> pt : points) 
            if( !location.equals(pt) )
                angles.add( calcAngle(location, pt) );
        Collections.sort(angles);
        
        int n = angles.size();
        int same = points.size() - n;
        
        for(int i=0; i<n; i++)
            if( angles.get(i) < 0 )
                angles.add(360 + angles.get(i));
        
        n = angles.size();
        
        for(int r=0, l=0; r<n; r++) {
            while( angles.get(r) - angles.get(l) > angle )
                l++;
            ans = Math.max(ans, r-l+1);
        }
        return ans + same;
    }
    
    private Double calcAngle(List<Integer> a, List<Integer> b) {
        int x1 = a.get(0), y1 = a.get(1);
        int x2 = b.get(0), y2 = b.get(1);
        return Math.toDegrees( Math.atan2(y2-y1, x2-x1) );
    }
}
