class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int open = 0, close = 0;
        
        for(int i=0; i<n; i++) {            
            if( arr[i] == '(' )
                open++;
            else if( arr[i]  == ')' ) 
                close++;
            
            if( close > open ) {
                arr[i] = '#';
                close--;
            }
        }
        
        open = 0;
        close = 0;
        
        for(int i=n-1; i>=0; i--) {            
            if( arr[i] == '(' )
                open++;
            else if( arr[i]  == ')' ) 
                close++;
            
            if( open > close ) {
                arr[i] = '#';
                open--;
            }
        }
        
        StringBuilder builder = new StringBuilder();
        for(char c : arr)
            if( c != '#' )
                builder.append(c);
        
        return builder.toString();
    }
}
// class Solution {
//     public String minRemoveToMakeValid(String s) {
//         StringBuilder builder = new StringBuilder(s);
//         int open = 0, close = 0;
//         int i = 0;
        
//         while( i < builder.length() ) {
//             char c = builder.charAt(i);
            
//             if( c == '(' )
//                 open++;
//             else if( c == ')' )
//                 close++;
//             else {
//                 i++;
//                 continue;
//             }
                
//             if( close > open ) {
//                 close--;
//                 builder.deleteCharAt(i);
//             } else
//                 i++;
//         }
        
//         open = 0;
//         close = 0;
//         i = builder.length() - 1;
        
//         while( i >= 0 ) {
//             char c = builder.charAt(i);
            
//             if( c == '(' )
//                 open++;
//             else if( c == ')' )
//                 close++;
//             else {
//                 i--;
//                 continue;
//             }
                
//             if( open > close ) {
//                 open--;
//                 builder.deleteCharAt(i);
//             } 
//             i--;
//         }
//         return builder.toString();
//     }
// }
