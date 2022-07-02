class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = 0, diff = Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        
        for(int i=0; i<n; i++) {     
            
            if( i != 0 && nums[i] == nums[i-1] )
                continue;
            
            int left = i+1, right = n-1;
            
            while( left < right ) {
                
                if( left != i+1 && nums[left] == nums[left-1] ) {
                    left++;
                    continue;
                }
                
                if( right != n-1 && nums[right] == nums[right+1] ) {
                    right--;
                    continue;
                }
                
                int sum = nums[i] + nums[left] + nums[right];
                
                int currDiff = Math.abs(target - sum);
                
                if( currDiff < diff ) {
                    ans = sum;
                    diff = currDiff;
                }
                
                if( sum == target )
                    return sum;
                else if( sum > target )
                    right--;
                else 
                    left++;
            }
        }
        return ans;
    }
}
