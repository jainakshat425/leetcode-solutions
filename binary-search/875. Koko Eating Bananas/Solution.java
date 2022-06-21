class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;        
        int low = 1, high = arrayMax(piles);
        int ans = high;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if( canEatAll(mid, piles, h) ) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    
    private int arrayMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int val : arr) 
            if( val > max )
                max = val;
        return max;
    }
    
    private boolean canEatAll(int k, int[] piles, int h) {
        int currH = 0;
        
        for(int pile : piles) {
            currH += pile / k;
            
            if(pile % k != 0) 
                currH++;
            
            if( currH > h ) 
                return false;
        }
        return true;
    }
}
