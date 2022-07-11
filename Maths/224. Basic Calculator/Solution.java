class Solution {
    public int calculate(String s) {
        // use int[] instead of int for index, to maintain reference between
        // recursive calls
        return calculate(new int[]{ 0 }, s.length(), s);
    }
    
    private int calculate(int[] i, int n, String s) {
        // Running sum
        int ans = 0;
        // Current unprocessed number
        int num = 0;
        // Previous operator: 1 for '+' and -1 for '-'
        int op = 1;
        
        while( i[0] < n ) {
            char c = s.charAt(i[0]);
            
            // digit? accumulate it in num
            if( Character.isDigit(c) ) 
                num = num * 10 + (c - '0');
            
            // new sign? process num using previous operator
            else if( c == '+' || c == '-' ) {
                ans += op * num;
                op = c == '+' ? 1 : -1; 
                num = 0;
            } 
            
            // open paren? recursively calculate for nested paren
            else if( c == '(' ) {
                i[0] += 1;
                ans += op * calculate(i, n, s);
            }  
            
            // close paren? current group is processed - break
            else if( c == ')' ) 
                break;
            
            // move to next indice, spaces will be skipped
            i[0] += 1;
        }
        // reached end of the string or a closing paren? 
        // process last num, and return the ans
        return ans + op * num;
    }
}
// class Solution {
//     public int calculate(String s) {
//         int n = s.length();
//         return calculate(0, n, s)[0];
//     }
    
//     private int[] calculate(int i, int n, String s) {
//         int ans = 0;
//         int num = 0;
//         int op = 1;
        
//         while( i < n ) {
//             char c = s.charAt(i);
            
//             if( Character.isDigit(c) ) 
//                 num = num * 10 + (c - '0');
            
//             else if( c == '+' || c == '-' ) {
//                 ans += op * num;
//                 op = c == '+' ? 1 : -1; 
//                 num = 0;
//             } 
//             else if( c == '(' ) {
//                 int[] res = calculate(i+1, n, s);
//                 ans += op * res[0];
//                 i = res[1];
//             }
//             else if( c == ')' ) 
//                 break;
            
//             i++;
//         }
//         ans += op * num;
//         return new int[]{ ans, i };
//     }
// }
