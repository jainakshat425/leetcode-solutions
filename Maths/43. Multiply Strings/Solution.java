class Solution {
    public String multiply(String num1, String num2) {
        if( num2.length() > num1.length() )
            return multiply(num2, num1);
        
        int m = num1.length();
        int n = num2.length();
        StringBuilder builder = new StringBuilder();
        
        for(int i=n-1; i>=0; i--) {
            
            int sumInd = n-i-1;
            int carry = 0;
            int multiplier = num2.charAt(i) - '0';
            
            for(int j=m-1; j>=0 || carry > 0; j--) {
                                
                int multiplicand = j >= 0 ? num1.charAt(j) - '0' : 0;
                                
                int prevVal = sumInd < builder.length() ? builder.charAt(sumInd) - '0' : 0;
                
                int sum = prevVal + (multiplier * multiplicand) + carry;

                int val = sum % 10;
                
                if( sumInd < builder.length() )
                    builder.setCharAt(sumInd, (char)(val + '0'));
                else 
                    builder.append(val);
                
                carry = sum / 10;
                sumInd++;
            }
        }
        
        for(int i=builder.length()-1; i>0; i--) {
            if( builder.charAt(i) != '0' )
                break;
            builder.deleteCharAt(i);
        }
        return builder.reverse().toString();
    }
}
