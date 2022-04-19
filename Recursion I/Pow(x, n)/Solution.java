class Solution {
    public double myPow(double x, int n) {
        /* 
        1. Call {myPowRecursive} to calculate x^n recursively.
            - Base case - if power {n} == 0, return 1.
            - Calculate {x}^{n/2} and store in {ans}
            - If {n} is even, return {ans} * {ans}
            - else {n} is odd, return {ans} * {ans} * x
        2. Return 1/{ans} if power {n} is negative else return {ans}
        */
        
        // Call {myPowRecursive} to calculate x^n recursively.
        double ans = myPowRecursive(x, n);
        
        // Return 1/{ans} if power {n} is negative else return {ans}
        return n < 0 ? 1/ans : ans;
    }

    private double myPowRecursive(double x, int n) {
        // Base case - if power {n} == 0, return 1.
        if( n == 0 ) return 1;
        
        // Calculate {x}^{n/2} and store in {ans}
        double ans = myPowRecursive(x, n/2);
        
        // If {n} is even, return {ans} * {ans}
        if( n%2 == 0 ) {
            return ans*ans;
        } else {
            // else {n} is odd, return {ans} * {ans} * x
            return ans*ans*x;
        }
    }
}
