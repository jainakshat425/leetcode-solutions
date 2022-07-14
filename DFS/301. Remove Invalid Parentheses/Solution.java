class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> visited = new HashSet();
        List<String> ans = new ArrayList();
        Queue<String> queue = new LinkedList();
        
        queue.offer(s);
        
        while( !queue.isEmpty() ) {
            int size = queue.size();
            
            while( size-- > 0 ) {
                String curr = queue.poll();
                
                if( isValid(curr) )
                    ans.add( curr );
                
                if( !ans.isEmpty() ) 
                    continue;
                
                int len = curr.length();
                
                for(int i=0; i<len; i++) {
                    char c = s.charAt(i);

                    if( c != '(' && c != ')' ) 
                        continue;
                    
                    String newStr = curr.substring(0,i) + curr.substring(i+1, len);
                    
                    if( visited.add(newStr) ) 
                        queue.offer(newStr);
                }
            }
            if( !ans.isEmpty() )
                break;
        }
        return ans;
    }
    
    private boolean isValid(String s) {
        int open = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if( c == '(' )
                open++;
            else if( c == ')' )
                open--;
            
            if( open < 0 )
                return false;
        }
        return open == 0;
    }
}
// class Solution {
//     public List<String> removeInvalidParentheses(String s) {
//         Set<String> ans = new HashSet();
//         buildValid(0, 0, new StringBuilder(), s, ans, new int[]{ 0 });
//         return new ArrayList<String>(ans);
//     }
    
//     private void buildValid(int i, int open, StringBuilder sb, String s, Set<String> ans, int[] maxLen) {
//         if( i == s.length() ) {
//             if( open != 0 )
//                 return;
            
//             if( sb.length() == maxLen[0] )
//                 ans.add( sb.toString() );
//             else if( sb.length() > maxLen[0]) {
//                 ans.clear();
//                 ans.add( sb.toString() );
//                 maxLen[0] = sb.length();
//             }
//             return;
//         }
        
//         char c = s.charAt(i);
        
//         // not take
//         buildValid(i+1, open, sb, s, ans, maxLen);
        
//         if( c == ')' && open == 0 )
//             return;
        
//         // take
//         sb.append(c);

//         int newOpen = c == '(' ? open+1 : (c == ')' ? open-1 : open);

//         buildValid(i+1, newOpen, sb, s, ans, maxLen);

//         sb.deleteCharAt(sb.length() - 1);
//     }
// }
