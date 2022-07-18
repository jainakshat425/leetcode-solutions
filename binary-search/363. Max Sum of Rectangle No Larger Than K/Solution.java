class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;

        for(int L=0; L<n; L++) {
            int[] nums = new int[m];
            
            for(int R=L; R<n; R++) {
                
                for(int row=0; row<m; row++) 
                    nums[row] += matrix[row][R];
                
                int sum = maxSubarraySum(nums, k);
                
                ans = Math.max(ans, sum);
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
    
    private int maxSubarraySum(int[] nums, int k) {
        int sum = 0, max = Integer.MIN_VALUE;
        TreeSet<Integer> preSum = new TreeSet();
        preSum.add( 0 );
        
        for(int num : nums) {
            sum += num;
            
            Integer left = preSum.ceiling( sum - k );
            
            if( left != null  )
                max = Math.max(max, sum - left);
                
            preSum.add( sum );
        }
        return max;
    }
}
