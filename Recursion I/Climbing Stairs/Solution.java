class Solution {
    
    private static Map<Integer,Integer> cache = new HashMap<Integer,Integer>();
    
    
    public int climbStairs(int n) {
        /* 
        1, 2 ,3, 4, 5, 6
        1, 2, 3, 5, 8, 13
        */
        
        /* 
        1. For {n} from 1 to 3, the number of distinct ways to climb stairs is equal to number of stairs.
        2. For each {n} > 3, the number of distinct ways to climb stairs is equal to number of distinct ways to climb {n-2} + number of distinct ways to climb {n-1}.
        */
        
        if( cache.containsKey( n ) ) return cache.get( n );
        
        int result;
        
        // For {n} from 1 to 3, the number of distinct ways to climb stairs is equal to number of stairs.
        if( n < 4 ) {
            result = n;
        } else {
            // For each {n} > 3, the number of distinct ways to climb stairs is equal to number of distinct ways to climb {n-2} + number of distinct ways to climb {n-1}.
            result = climbStairs( n - 2 ) + climbStairs( n - 1 );
        }
        
        cache.put( n, result );
        
        return result;
    }
}
