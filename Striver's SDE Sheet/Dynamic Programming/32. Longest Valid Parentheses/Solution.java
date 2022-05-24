class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int open = 0, close = 0;
        int max = 0;
        
        for(int i=0; i<n; i++) {
            if( s.charAt(i) == '(' )
                open++;
            else 
                close++;
            
            if( close == open ) 
                max = Math.max(max, open+close);
            else if( close > open ) {
                open = 0;
                close = 0;
            }         
        }
        open = close = 0;
        
        for(int i=n-1; i>=0; i--) {
            if( s.charAt(i) == '(' )
                open++;
            else 
                close++;
            
            if( close == open ) 
                max = Math.max(max, open+close);
            else if( open > close ) {
                open = 0;
                close = 0;
            }         
        }
        return max;
    }
}
/*
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int max = 0;
        
        for(int i=0; i<n; i++) {
            if( s.charAt(i) == '(' )
                stack.push( i );
            else {
                stack.pop();
                if( stack.isEmpty() ) 
                    stack.push( i );
                else 
                    max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }
}
*/
