class Solution {
    public int minimumSize(int[] nums, int maxOps) {
        int low = 1, high = IntStream.of(nums).max().getAsInt();
        int ans = high;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if( isValidSize(mid, nums, maxOps) ) {
                ans = mid;
                high = mid-1;
            } else 
                low = mid+1;
        }
        return ans;
    }
    
    private boolean isValidSize(int size, int[] nums, int maxOps) {
        int ops = 0;
        
        for(int num : nums) {
            if( num > size ) 
                ops += (num-1)/size;
            
            if( ops > maxOps )
                return false;
        }
        return true;
    }
}
