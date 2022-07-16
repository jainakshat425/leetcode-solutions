class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = Integer.MIN_VALUE, hi = 0;
        
        for(int wt : weights) {
            lo = Math.max(lo, wt);
            hi += lo;
        }
        
        int ans = hi;
        
        while( lo <= hi ) {
            int mid = lo + (hi - lo)/2;
            
            if( isValidCapacity(mid, weights, days) ) {
                hi = mid-1;
                ans = mid;
            } else 
                lo = mid+1;
        }
        return ans;
    }
    
    private boolean isValidCapacity(int capacity, int[] weights, int days) {
        int currWeight = 0, reqDays = 1;

        for(int i=0; i<weights.length; i++) {
            if( reqDays > days )
                return false;
            
            if( currWeight + weights[i] > capacity ) {
                currWeight = weights[i];
                reqDays++;
            } else 
                currWeight += weights[i];
        }
        return reqDays <= days;
    }
}
