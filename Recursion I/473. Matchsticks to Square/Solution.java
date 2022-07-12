class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int sum = Arrays.stream(matchsticks).sum();
        
        if( sum % 4 != 0 )
            return false;
        
        Arrays.sort(matchsticks);
        
        return findSum(n-1, 0, 0, sum/4, matchsticks);
    }
    
    private boolean findSum(int i, int sum, int found, int target, int[] ms) {
        if( sum == target ) {
            if( ++found == 4 ) 
                return true;
            else
                return findSum(ms.length-1, 0, found, target, ms);            
        }
        if( i == -1 )
            return false;
        
        boolean take = false;
        
        int val = ms[i];
        if( val != 0 && sum + val <= target ) {
            ms[i] = 0;
            take = findSum(i-1, sum + val, found, target, ms);
            ms[i] = val;
        }
        
        return take || findSum(i-1, sum, found, target, ms);
    }
}
