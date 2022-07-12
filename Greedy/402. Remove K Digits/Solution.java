class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> stack = new Stack();
        
        for(int i=0; i<n; i++) {
            char digit = num.charAt(i);
            
            while( k > 0 && !stack.isEmpty() && stack.peek() > digit ) {
                stack.pop();
                k--;
            }
            if( !stack.isEmpty() || digit != '0' )
                stack.push(digit);
        }
        
        while( !stack.isEmpty() && k > 0 ) {
            stack.pop();
            k--;
        }
        
        if( stack.isEmpty() )
            return "0";
        
        char[] ans = new char[stack.size()];
        
        while( !stack.isEmpty() ) 
            ans[stack.size() - 1] = stack.pop();
        
        return new String(ans);
    }
}
