class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if( numerator == 0 )
            return "0";
        
        StringBuilder quotient = new StringBuilder();        
        // Iff one of the num or deno is negative, ans will be negative
        quotient.append((numerator < 0 ^ denominator < 0) ? "-" : "");
        
        long dividend = Math.abs((long)numerator);
        long divisor = Math.abs((long)denominator);
        
        quotient.append( dividend/divisor );
        // New dividend will be the remainder
        dividend %= divisor;
        
        if( dividend == 0 ) 
            return quotient.toString();
        
        Map<Long,Integer> numToInd = new HashMap();
        quotient.append(".");
            
        while( dividend != 0 ) {
            numToInd.put(dividend, quotient.length());
            
            dividend *= 10;
            quotient.append( dividend/divisor );
            dividend %= divisor;
            
            if( numToInd.containsKey( dividend ) ) {
                // start is the index from where recurring decimal is starting
                int start = numToInd.get(dividend);
                
                quotient.insert(start, '(' );
                quotient.append( ")" );
                break;
            }
        }
        return quotient.toString();
    }
}
