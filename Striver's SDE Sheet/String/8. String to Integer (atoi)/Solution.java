class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        char sign = '\0';
        int num = 0;
        boolean numFound = false;
        int th = Integer.MAX_VALUE/10;
        
        for(int i=0; i<n; i++) {
            char curr = s.charAt(i);
            
            if( Character.isDigit( curr ) ) {
                int currNum = (curr - '0');
                numFound = true;
                
                if( num > th ) 
                    return sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                else if( num == th ) {
                    if( sign == '-' && currNum >= 8 ) 
                        return Integer.MIN_VALUE;
                    else if( sign != '-' && currNum >= 7 )  
                        return Integer.MAX_VALUE;
                }
                num = (num*10) + currNum;
                                
            } else if( !numFound && sign == '\0') {
                if( curr == '+' || curr == '-' ) 
                    sign = curr;
                else if( curr != ' ' )
                    break;
            } else {
                break;
            }
        }
        
        return sign == '-' ? -num : num;
    }
}
