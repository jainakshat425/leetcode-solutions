class Solution {
    public int mySqrt(int x) {
        /* 
        1. For numbers less than 2, square root of number = number.
        2. Square root of the number {x} exist in between 0 and {x/2}
        3. Intialize integer {start} with 0 and {end} with {x/2}.
        4. Repeat while {start} <= {end}
            - Find {mid}
            - Square {mid} and store it in {sqr}
            - if mid is the square root, {sqr} == {x}, return {mid}.
            - else if {sqr} > {x}, search in the left half.
            - else if {sqr} < {x}, search in the right half
        */
        
        // For numbers less than 2, square root of number = number.
        if( x < 2 ) return x;
        
        // Square root of the number {x} exist in between 0 and {x/2}
        // Intialize integer {start} with 0 and {end} with {x/2}.
        int start = 0, end = x/2;
        
        // Repeat while {start} <= {end}
        while( start <= end ) {
            
            // Find {mid}
            int mid = (start+end)/2;
            
            // Square {mid} and store it in {sqr}
            long sqr = (long) mid*mid;
            
            // if mid is the square root, {sqr} == {x}, return {mid}.
            if( sqr == x ) {
                return mid;
            } else if( sqr > x ) {
                // else if {sqr} > {x}, search in the left half.
                end = mid-1;
            } else {
                // else if {sqr} < {x}, search in the right half
                start = mid+1;
            }
        }
        
        return end;
    }
}
