class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int surplus = 0, totalSurplus = 0;
        
        for(int i=0; i<n; i++) {
            totalSurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            
            if( surplus < 0 ) {
                surplus = 0;
                start = i+1;
            }
        }
        return totalSurplus < 0 ? -1 : start;
    }
}
/* 
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        for(int i=0; i<n; i++) {
            int stopCount = 0;
            int curr = i;
            int gasLeft = gas[curr];
            
            while( gasLeft >= cost[curr] ) {
                stopCount++;
                int next = (curr + 1) % n;
                gasLeft = gasLeft - cost[curr] + gas[next];
                curr = next;
                
                if( stopCount == n )
                    return i;
            }
        }
        return -1;
    }
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        for(int i=0; i<n; i++) {
            int dest = i == 0 ? n-1 : i-1;
             System.out.println();
            if( gas[i] >= cost[i] && isPossible(i, gas[i], dest, n, gas, cost) ) 
                return i;
        }
        return -1;
    }
    
    private boolean isPossible(int start, int gasLeft, int dest, int n, int[] gas, int[] cost) {
        // System.out.println(start + " " + gasLeft + " " + dest);
        if( gasLeft < cost[start] )
            return false;
        
        if( start == dest )
            return true;
        
        int next = start == n-1 ? 0 : start+1;
        gasLeft = gasLeft - cost[start] + gas[next];
        
        return isPossible(next, gasLeft, dest, n, gas, cost);
    }
}
*/
