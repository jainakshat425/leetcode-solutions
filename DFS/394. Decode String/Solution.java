class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Stack<Integer> count = new Stack();
        Stack<StringBuilder> substr = new Stack();
        StringBuilder curStr = new StringBuilder();
        int curCount = 0;
        
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            
            if( Character.isDigit(c) ) 
                curCount = curCount * 10 + (c - '0');
            
            else if( c == '[') {
                count.push(curCount);
                substr.push(curStr);
                curStr = new StringBuilder();
                curCount = 0;
            }
            else if( c == ']' ) {
                StringBuilder temp = curStr;
                curStr = substr.pop();
                int repeat = count.pop();
                
                for(int j=0; j<repeat; j++)
                    curStr.append(temp);
            }            
            else curStr.append(c);
        }
        return curStr.toString();
    }
    
    private String decodeStr(int[] index, int n, String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while( index[0] < n ) {
            char c = s.charAt(index[0]);
            
            if( Character.isDigit(c) ) 
                num = num * 10 + (c - '0');
            
            else if( c == '[') {
                index[0] += 1;
                String substr = decodeStr(index, n, s);
                
                for(int i=0; i<num; i++)
                    sb.append(substr);
                
                num = 0;
            }
            else if( c == ']' ) break;
            
            else sb.append(c);
            
            index[0] += 1;
        }
        return sb.toString();
    }
}
// class Solution {
//     public String decodeString(String s) {
//         return decodeStr(new int[]{0}, s.length(), s);
//     }
    
//     private String decodeStr(int[] index, int n, String s) {
//         StringBuilder sb = new StringBuilder();
//         int num = 0;
//         while( index[0] < n ) {
//             char c = s.charAt(index[0]);
            
//             if( Character.isDigit(c) ) 
//                 num = num * 10 + (c - '0');
            
//             else if( c == '[') {
//                 index[0] += 1;
//                 String substr = decodeStr(index, n, s);
                
//                 for(int i=0; i<num; i++)
//                     sb.append(substr);
                
//                 num = 0;
//             }
//             else if( c == ']' ) break;
            
//             else sb.append(c);
            
//             index[0] += 1;
//         }
//         return sb.toString();
//     }
// }
