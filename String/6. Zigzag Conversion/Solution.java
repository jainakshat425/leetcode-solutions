class Solution {
    public String convert(String s, int numRows) {
        if( numRows == 1 ) return s;
        
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        
        for(int r=0; r<numRows; r++) {
            int inc = (numRows-1) * 2;
            
            for(int i = r; i < n; i += inc) {
                ans.append( s.charAt(i) );
                
                if( r == 0 || r == numRows-1 ) continue;
                
                int diagInd = i + inc - 2 * r;
                
                if( diagInd < n )
                    ans.append( s.charAt(diagInd) );
            }
        }
        return ans.toString();
    }
}
// class Solution {
//     public String convert(String s, int numRows) {
//         int n = s.length();
//         List<StringBuilder> rows = new ArrayList();
//         StringBuilder ans = new StringBuilder();
        
//         for(int k=0; k<numRows; k++)
//             rows.add(new StringBuilder());
        
//         int i = 0;
//         while( i < n ) {
//             int r = 0;
            
//             while( i < n && r < numRows ) 
//                 rows.get(r++).append(s.charAt(i++));
            
//             r -= 2;
            
//             while( i < n && r > 0 ) 
//                 rows.get(r--).append(s.charAt(i++));
//         }
        
//         int r = 0;
        
//         while( r < numRows && !rows.get(r).isEmpty() )
//             ans.append(rows.get(r++));
        
//         return ans.toString();
//     }
// }
