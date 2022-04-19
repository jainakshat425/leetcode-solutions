class Solution {
    
    private static Map<Integer,Integer> cache = new HashMap<>();
    
    public int tribonacci(int n) {
        if( n == 0 || n == 1 ) return n;
        if( n == 2 ) return 1;
        
        int result;
        if( cache.containsKey( n ) ) {
            result = cache.get( n );
        } else {
            result = tribonacci( n-3 ) + tribonacci( n-2 ) + tribonacci( n-1 );
        }
        cache.put(n, result);
        
        return result;
    }
}
