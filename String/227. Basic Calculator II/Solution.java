class Solution {
    public int calculate(String s) {
        int n = s.length();
        char operation = '+';
        int currNum = 0;
        int lastNum = 0;
        int ans = 0;

        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            
            if( Character.isDigit(c) ) 
                currNum = currNum*10 + (c-'0');
        
            if( (!Character.isDigit(c) && c != ' ') || i == n-1 ) {
                
                if( operation == '+' || operation == '-' ) {
                    ans += lastNum;
                    lastNum = operation == '+' ? currNum : -currNum;
                }
                else if( operation == '*' )
                    lastNum = lastNum * currNum;
                
                else if( operation == '/' )
                    lastNum = lastNum / currNum;
                
                operation = c;
                currNum = 0;
            }
        }
        ans += lastNum;
        
        return ans;
    }
}
// class Solution {
//     public int calculate(String s) {
//         int n = s.length();
//         Stack<Integer> stack = new Stack();
//         char operation = '+';
//         int currNum = 0;
//           // 3/2    
//         for(int i=0; i<n; i++) {
//             char c = s.charAt(i);
            
//             if( Character.isDigit(c) ) 
//                 currNum = currNum*10 + (c-'0');
        
//             if( (!Character.isDigit(c) && c != ' ') || i == n-1 ) {
                
//                 if( operation == '+' )
//                     stack.push( currNum );
                
//                 else if( operation == '-' )
//                     stack.push( -currNum );
                
//                 else if( operation == '*' )
//                     stack.push(stack.pop() * currNum);
                
//                 else if( operation == '/' )
//                     stack.push(stack.pop() / currNum);
                
//                 operation = c;
//                 currNum = 0;
//             }
//         }
        
//         int ans = 0;
//         while( !stack.isEmpty() ) {
//             ans += stack.pop();
//         }
        
//         return ans;
//     }
// }
