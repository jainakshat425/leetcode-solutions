class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        boolean allowDecimal = true, allowExp = true, digitFound = false;
        
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            
            // All digits allowed
            if( Character.isDigit(c) ) 
                digitFound = true;
            
            // Before a sign, there should be an expontential or no character at all
            // Num cannot end with a sign
            else if( c == '+' || c == '-' ) {
                char prevC = i == 0 ? '\0' : s.charAt(i-1);
                if( (prevC != '\0' && prevC != 'e' && prevC != 'E') || i == n-1  )
                    return false;
            }
            
            // Before a expontential, there must exist a digit
            // Exponential can only occur once and it should not be the last char
            else if( c == 'e' || c == 'E' ) {
                if( !digitFound || i == n-1 || !allowExp )
                    return false;
                allowExp = false;
            }
            
            // Decimal can only occur once and it should not be after an exponential char
            else if( c == '.' ) {
                if( !allowDecimal || !allowExp )
                    return false;
                allowDecimal = false;
            }
            
            // Any other character will lead to an invalid num
            else return false;
        }
        
        // Number should contain atleast one digit
        return digitFound;
    }
}
