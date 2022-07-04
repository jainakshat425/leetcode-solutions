class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer,Integer> points = new TreeMap();
        
        for(int num : nums) 
            points.put(num, points.getOrDefault(num, 0) + num);
        
        int twoBack = 0, oneBack = 0;
        int prevNum = Integer.MIN_VALUE;

        for(int num : points.keySet()) {
            
            int point = points.get(num);
            int temp = oneBack;
            
            if( num-prevNum != 1 )
                oneBack += point;
            else 
                oneBack = Math.max(oneBack, point + twoBack);
            
            twoBack = temp;
            prevNum = num;
        }
        return oneBack;
    }
}
// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int n = nums.length;
//         Map<Integer,Integer> points = new HashMap();
//         int maxNum = 0;
        
//         for(int num : nums) {
//             points.put(num, points.getOrDefault(num, 0) + num);
//             maxNum = Math.max(maxNum, num);
//         }
        
//         int twoBack = 0, oneBack = points.getOrDefault(1,0);
        
//         for(int num=2; num<=maxNum; num++) {
//             int temp = oneBack;
//             oneBack = Math.max(oneBack, points.getOrDefault(num,0) + twoBack);
//             twoBack = temp;
//         }
//         return oneBack;
//     }
// }
// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int n = nums.length;
//         Map<Integer,Integer> points = new HashMap();
//         int maxNum = 0;
        
//         for(int num : nums) {
//             points.put(num, points.getOrDefault(num, 0) + num);
//             maxNum = Math.max(maxNum, num);
//         }
        
//         int[] maxPoints = new int[maxNum+1];
//         maxPoints[1] = points.getOrDefault(1,0);
        
//         for(int num=2; num<=maxNum; num++) 
//             maxPoints[num] = Math.max(
//                 maxPoints[num-1], 
//                 points.getOrDefault(num,0) + maxPoints[num-2]
//             );
        
        
//         return maxPoints[maxNum];
//     }
// }
// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n+1][n+1];
        
//         for(int[] state : dp)
//             Arrays.fill(state, -1);
//         Arrays.sort(nums);
//         return earnMax(n, 0, nums, dp);
//     }
    
//     private int earnMax(int i, int j, int[] nums, int[][] dp) {
//         if( i == 0 )
//             return 0;
        
//         if( dp[i][j] != -1 )
//             return dp[i][j];
        
//         int val = nums[i-1];
//         int points = val;
        
//         while( i > 1 && nums[i-2] == val ) {
//             points += val;
//             i--;
//         }
        
//         if( dp[i][j] != -1 )
//             return dp[i][j];
        
//         int notTake = earnMax(i-1, j, nums, dp);
//         int take = 0;
        
//         if( j == 0 || nums[i-1] != nums[j-1]-1) 
//             take = points + earnMax(i-1, i, nums, dp);
        
//         return dp[i][j] = Math.max(take, notTake);
//     }
// }
