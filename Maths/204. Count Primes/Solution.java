class Solution {
    public int countPrimes(int n) {
        if( n < 2 ) return 0;
        
        boolean[] composite = new boolean[n];
        int compositeCount = 0;
        
        int sqrt = (int)Math.sqrt(n);
        
        for(int i=2; i<=sqrt; i++) {
            if( composite[i] ) 
                continue;
                
            for(int j=2; i*j<n; j++) {
                if( composite[i*j] ) 
                    continue;
                
                composite[i*j] = true;
                compositeCount++;
            }
        }
        // subtract by 2 to exclude 1 and n
        return n-compositeCount-2;
    }
}
