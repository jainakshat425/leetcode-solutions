class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = arrayMax(nums);
        int ans = 1;
        
        while( low <= high ) {
            int mid = low + (high-low)/2;
            
            if( isValidDivisor(mid, nums, threshold) ) {
                ans = mid;
                high = mid-1;
            } else
                low = mid+1;
        }
        return ans;
    }
    
    private boolean isValidDivisor(int divisor, int[] nums, int threshold) {
        int sum = 0;
        for(int num : nums) {
            sum += Math.ceil((double)num/divisor);
            if( sum > threshold )
                return false;
        }        
        return sum <= threshold;
    }
    
    private int arrayMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums)
            max = Math.max(max, num);
        return max;
    }
}
