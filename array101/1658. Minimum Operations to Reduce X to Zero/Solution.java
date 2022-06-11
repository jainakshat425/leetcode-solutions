class Solution {
        
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        
        int target = -x;
        for(int i=0; i<n; i++) 
            target += nums[i];
        
        int left = 0;
        int sum = 0;
        // Maximum subarray length with sum = target, where target = total - x
        int len = -1;
        
        for(int right=0; right<n; right++) {
            sum += nums[right];
            
            while( left <= right && sum > target ) 
                sum -= nums[left++];
            
            if( sum == target ) 
                len = Math.max(len, right-left+1);
        }
        return len == -1 ? -1 : n - len;
    }
}

/*
class Solution {
        
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        Map<Integer,Integer> sumToInd = new HashMap();
        int sum = 0;
        
        for(int i=0; i<n; i++) {
            sum += nums[i];
            sumToInd.put(sum, i);
        }
        
        int min = sumToInd.containsKey(x) ? sumToInd.get(x)+1 : Integer.MAX_VALUE;
        
        for(int i=n-1; i>=0; i--) {
            if( nums[i] > x )
                break;
            if( nums[i] == x ) {
                min = Math.min(min, n-i);
                break;
            }
            x -= nums[i];
            
            int sumInd = sumToInd.getOrDefault(x, -1);
            
            if( sumInd >= i )
                break;
            
            int newMin = sumInd != -1 ? n-i+sumInd+1 : Integer.MAX_VALUE;
            min = Math.min(min, newMin);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
*/
/*
class Solution {
    
    private static final int MAX = (int)1e6;
    
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[][][] dp = new int[n][n][x+1];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                
                if( i == j ) {
                    for(int k=0; k<=x; k++) 
                        dp[i][j][k] = nums[i] == x ? 1 : MAX;
                }
                
                dp[i][j][0] = 0;
            }
        }
        
        for(int left=n-1; left>=0; left--) {
            for(int right=left+1; right<n; right++) {
                for(int target=1; target<=x; target++) {
                    int takeLeft = MAX;
                    if( nums[left] <= target )
                        takeLeft = 1 + dp[left+1][right][target-nums[left]];

                    int takeRight = MAX;
                    if( nums[right] <= target )
                        takeRight = 1 + dp[left][right-1][target-nums[right]];

                    dp[left][right][target] = Math.min(takeLeft, takeRight);
                }
            }
        }
        return dp[0][n-1][x] >= MAX ? -1 : dp[0][n-1][x];
    }
}
*/
/* 
class Solution {
    
    private static final int MAX = (int)1e6;
    
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[][][] dp = new int[n][n][x+1];
        int min = minOps(0, n-1, x, nums, dp);
        return min >= MAX ? -1 : min;
    }
    
    private int minOps(int left, int right, int target, int[] nums, int[][][] dp) {
        if( target == 0 )
            return 0;
        
        if( left == right ) 
            return nums[left] == target ? 1 : MAX;
        
        if( dp[left][right][target] != 0 ) 
            return dp[left][right][target];
            
        int takeLeft = MAX;
        if( nums[left] <= target )
            takeLeft = 1 + minOps(left+1, right, target-nums[left], nums, dp);
        
        int takeRight = MAX;
        if( nums[right] <= target )
            takeRight = 1 + minOps(left, right-1, target-nums[right], nums, dp);
        
        return dp[left][right][target] = Math.min(takeLeft, takeRight);
    }
}
*/
