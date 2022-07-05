class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1, n = num2.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        
        while( m >= 0 || n >= 0 || carry > 0 ) {
            int val1 = m >= 0 ? num1.charAt(m--) - '0' : 0;
            int val2 = n >= 0 ? num2.charAt(n--) - '0' : 0;
            
            int sum = val1 + val2 + carry;
            
            builder.append(sum % 10);
            
            carry = sum / 10;
        }
        return builder.reverse().toString();
    }
}
