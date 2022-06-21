class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int fleets = 0;
        double currMaxTime = 0;
        // 0 > position, 1 > speed
        int[][] pairs = new int[n][2];
        
        for(int i=0; i<n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        
        for(int i=n-1; i>=0; i--) {
            double time = (double)(target-pairs[i][0])/pairs[i][1];
            
            if( time > currMaxTime ) {
                fleets++;
                currMaxTime = time;
            }
        }
        
        return fleets;
    }
}
