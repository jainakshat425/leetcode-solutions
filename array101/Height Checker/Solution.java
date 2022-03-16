class Solution {
    public int heightChecker(int[] heights) {
        /* 
        1. Create an array heightCounts to store count of each height.
        2. Start searching from the zero to the index for which height exist in heightCounts.
        3. If current height doesn't match the height expected by heightCounts array
            - Increment the count of mismatch.
        4. Decrement the count of current height in heightCounts array.
        */
        
        // Create an array heightCounts to store count of each height.
        int[] heightCounts = new int[101];
            
        for(int num : heights) {
            heightCounts[num]++;
        }
        
        int count = 0;
        int currHeight = 0;
        
        for(int i=0; i<heights.length; i++) {
            
            // Start searching from the zero to the index for which height exist in heightCounts.
            while( heightCounts[currHeight] == 0 ) {
                currHeight++;
            }
            
            // If current height doesn't match the height expected by heightCounts array
            if( heights[i] != currHeight ) {
                
                // Increment the count of mismatch.
                count++;
            }
            
            // Decrement the count of current height in heightCounts array.
            heightCounts[currHeight]--;
        }
        return count;
    }
}
