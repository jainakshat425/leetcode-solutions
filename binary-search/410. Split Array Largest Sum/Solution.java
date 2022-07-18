class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int low = Integer.MIN_VALUE, high = 0;
        
        for(int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        
        int ans = high;
        
        while( low <= high ) {
            int mid = low + (high-low)/2;
            
            if( isValidSplit(mid, nums, m) ) {
                ans = mid;
                high = mid-1;
            } else
                low = mid+1;
        }
        
        return ans;
    }   
    
    private boolean isValidSplit(int maxSum, int[] nums, int m) {
        int curSum = 0;
        
        for(int num : nums) {
            if( num > maxSum )
                return false;
            
            if( curSum + num > maxSum ) {
                curSum = 0;
                m--;
                
                if( m == 0 )
                    return false;
            }
            curSum += num;
        }
        return true;
    }
}
// class Solution {
//     public int splitArray(int[] nums, int m) {
//         int n = nums.length;
//         int[] suffixSum = new int[n];
//         suffixSum[n-1] = nums[n-1];
        
//         for(int i=n-2; i>=0; i--)
//             suffixSum[i] = nums[i] + suffixSum[i+1];
        
//         Integer[][] dp = new Integer[n][m];
        
//         return minPart(0, m-1, nums, suffixSum, dp);
//     }
    
//     private int minPart(int start, int m, int[] nums, int[] suffixSum, Integer[][] dp) {        
//         if( start == nums.length )
//             return Integer.MAX_VALUE;
        
//         if( m == 0 ) 
//             return suffixSum[start];
        
//         if( dp[start][m] != null )
//             return dp[start][m];
        
//         int sum = 0;
//         int ans = Integer.MAX_VALUE;
        
//         for(int i=start; i<nums.length; i++) {
//             sum += nums[i];
            
//             int remainingMinSum = minPart(i+1, m-1, nums, suffixSum, dp);

//             // System.out.println(sum + " " + remainingMinSum);
//             ans = Math.min(ans, Math.max(sum, remainingMinSum));
//         }
//         return dp[start][m] = ans;
//     }
// }
