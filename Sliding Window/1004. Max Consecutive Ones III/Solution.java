class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0, flipped = 0;
        int left = 0;
        
        for(int right=0; right<n; right++) {
            
            if( nums[right] != 1 )
                flipped++;
            
            while( flipped > k ) 
                if( nums[left++] == 0 )
                    flipped--;
            
            ans = Math.max(ans, right-left+1);
        }
        
        return ans;
    }
}
