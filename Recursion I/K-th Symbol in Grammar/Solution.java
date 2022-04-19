class Solution {
    public int kthGrammar(int n, int k) {        
        /* 
        1. Base condition - if {n} == 1, return 0
        2. {k}th value at {n}th row get generated from {ceil(k/2)}th value at {n-1}th row.
            - Call {kthGrammar} recursively to find value {k/2}th value at {n-1}th row.
            - Type cast {k} to double before dividing by 2 to get the correct ceiling value of {k/2}.
            - If {k} is even, return inverse of {parent} ({k/2}th value at {n-1}th row), else return {parent} itself.
        */
        
        // Base condition - if {n} == 1, return 0
        if( n == 1 ) return 0;
        
        // {k}th value at {n}th row get generated from {ceil(k/2)}th value at {n-1}th row.
        // Call {kthGrammar} recursively to find value {k/2}th value at {n-1}th row.
        // Type cast {k} to double before dividing by 2 to get the correct ceiling value of {k/2}.
        int parent = kthGrammar(n-1, (int)Math.ceil( (double)k / 2 ) );
        
        // If {k} is even, return inverse of {parent} ({k/2}th value at {n-1}th row), else return {parent} itself.
        return (k%2 == 0) ? (1-parent) : parent;
    }
    
    /* 
        1- 0
        2- 01
        3- 0110
        4- 01101001
        5- 0110100110010110
    */
    
    /* Memory Limit Exceeded 
        StringBuilder acc = new StringBuilder("01");
        
        while( acc.length() < k ) {
            
            String firstHalf = acc.substring( 0, acc.length()/2 );
            String secondHalf = acc.substring( acc.length()/2, acc.length() );
            
            acc.append( secondHalf );
            acc.append( firstHalf );
        }
        
        return Character.getNumericValue( acc.charAt(k-1) );
    */
}
