class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] dp = new int[n+1];
        int ans = 0;
        
        for(int i=1; i<=m; i++) {
            for(int j=n; j>=1; j--) {
                if( nums1[i-1] == nums2[j-1] )
                    dp[j] = dp[j-1] + 1;
                else
                    dp[j] = 0;
                
                ans = Math.max(ans, dp[j]);
            }
        }
        return ans;
    }
}
