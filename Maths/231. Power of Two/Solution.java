class Solution {
    public boolean isPowerOfTwo(int n) {
        // for(int i=0; i<31; i++) 
        //     if( n == (1 << i) )
        //         return true;
        return n > 0 && (n & (n-1)) == 0;
    }
}
