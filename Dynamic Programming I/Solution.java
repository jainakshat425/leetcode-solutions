class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int up = 1, down = 1;
        
        for(int i=1; i<n; i++) {
            
            if( nums[i] > nums[i-1] )
                up = down + 1;
            else if( nums[i] < nums[i-1] )
                down = up + 1;
        }
        return Math.max(up, down);
    }
}
// class Solution {
//     public int wiggleMaxLength(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n+1];
        
//         for(int curr=n; curr>=1; curr--) {
//             for(int prev=curr-1; prev>=0; prev--) {
//                 if( curr == n ) {
//                     dp[prev] = n == 1 || prev == 0 || nums[curr-1] != nums[prev-1] ? 1 : 0;
//                     continue;
//                 }
                
//                 int take = 0;
//                 if( (prev == 0 || nums[prev-1] < nums[curr-1]) && nums[curr-1] > nums[curr] )
//                     take = 1 + dp[curr];

//                 else if( (prev == 0 || nums[prev-1] > nums[curr-1]) && nums[curr-1] < nums[curr] )
//                     take = 1 + dp[curr];

//                 dp[prev] = Math.max(dp[prev], take);
//             }
//         }
//         return dp[0];
//     }
// }
// class Solution {
//     public int wiggleMaxLength(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n+1][n+1];
        
//         for(int curr=n; curr>=1; curr--) {
//             for(int prev=curr-1; prev>=0; prev--) {
//                 if( curr == n ) {
//                     dp[curr][prev] = n == 1 || prev == 0 || nums[curr-1] != nums[prev-1] ? 1 : 0;
//                     continue;
//                 }
                
//                 int next = curr+1;

//                 int notTake = dp[next][prev];

//                 int takeLarge = 0;
//                 if( (prev == 0 || nums[prev-1] < nums[curr-1]) && nums[curr-1] > nums[next-1] )
//                     takeLarge = 1 + dp[next][curr];

//                 int takeSmall = 0;
//                 if( (prev == 0 || nums[prev-1] > nums[curr-1]) && nums[curr-1] < nums[next-1] )
//                     takeSmall = 1 + dp[next][curr];

//                 dp[curr][prev] = Math.max(notTake, Math.max(takeLarge, takeSmall));
//             }
//         }
//         return dp[1][0];
//     }
// }
// class Solution {
//     public int wiggleMaxLength(int[] nums) {
//         return wiggleMaxLength(0, -1, nums);
//     }
    
//     private int wiggleMaxLength(int curr, int prev, int[] nums) {
//         if( curr == nums.length - 1 )
//             return nums.length == 1 || prev == -1 || nums[curr] != nums[prev] ? 1 : 0;
        
//         int next = curr+1;
        
//         int notTake = wiggleMaxLength(curr+1, prev, nums);
        
//         int takeLarge = 0;
//         if( (prev == -1 || nums[prev] < nums[curr]) && nums[curr] > nums[next] )
//             takeLarge = 1 + wiggleMaxLength(curr+1, curr, nums);
        
//         int takeSmall = 0;
//         if( (prev == -1 || nums[prev] > nums[curr]) && nums[curr] < nums[next] )
//             takeSmall = 1 + wiggleMaxLength(curr+1, curr, nums);
        
//         return Math.max(notTake, Math.max(takeLarge, takeSmall));
//     }
// }
