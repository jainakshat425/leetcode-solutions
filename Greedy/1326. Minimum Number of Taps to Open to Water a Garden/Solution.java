class Solution {
    public int minTaps(int n, int[] ranges) {
        int reachable = 0, farthestReach = 0;
        int open = 0;
        int index = 0;
        
        while( reachable < n ) {
            for(int i=index; i<=n; i++) {
                if( i-ranges[i] <= reachable && i+ranges[i] > farthestReach ) {
                    farthestReach = i+ranges[i];
                    index = i+1;
                }
            }
            if( farthestReach == reachable )
                return -1;
            
            reachable = farthestReach;
            open++;
        }
        return open;
    }
}
