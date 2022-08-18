class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        // [plant time, grow time]
        int[][] plant = new int[n][2];
        
        for(int i=0; i<n; i++) 
            plant[i] = new int[]{ plantTime[i], growTime[i] };
        
        Arrays.sort(plant, (a,b) -> Integer.compare(b[1], a[1]));
        
        int totalTime = 0;
        int plantTimeTillNow = 0;
        
        for(int i=0; i<n; i++) {
            totalTime = Math.max(totalTime, plantTimeTillNow + plant[i][0] + plant[i][1]);
            plantTimeTillNow += plant[i][0];
        }
            
        return totalTime;
    }
}
