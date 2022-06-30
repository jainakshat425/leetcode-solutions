class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int sum = 0, min = Integer.MAX_VALUE;
        
        for(int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - (n * min);
    }
}
/* 
class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        
        if( n == 1 )
            return 0;
        
        Arrays.sort(nums);
        
        int count = nums[n-1] - nums[0];
        
        int maxInd = n-2;
        
        while( maxInd != 0 ) {
            nums[maxInd] += count;
            count += nums[maxInd] - nums[maxInd+1];
            maxInd--;
        }
        return count;
    }
}
*/
