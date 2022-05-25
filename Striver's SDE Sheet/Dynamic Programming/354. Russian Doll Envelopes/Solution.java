class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort asc on width, if width is same, sort desc on height
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        int n = envelopes.length;
        
        int[] dp = new int[n];
        
        int maxLen = 0;
        
        for(int i=0; i<n; i++) {
            int index = binarySearch(0, maxLen, dp, envelopes[i][1]);
            
            dp[index] = envelopes[i][1];
            
            if( index == maxLen )
                maxLen++;
        }
        return maxLen;
    }
    
    private int binarySearch(int low, int high, int[] nums, int num) {
        while( low < high ) {
            int mid = low + (high-low)/2;
            
            if( nums[mid] == num )
                return mid;
            else if( nums[mid] < num )
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
}
