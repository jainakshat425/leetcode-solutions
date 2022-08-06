class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        boolean[] upper = new boolean[26];
        boolean[] lower = new boolean[26];
        
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if( c >= 'A' && c <= 'Z' )
                upper[c-'A'] = true;
            else
                lower[c-'a'] = true; 
        }
        
        for(int i=0; i<n; i++) {
            char upCase = Character.toUpperCase(s.charAt(i));
            char loCase = Character.toLowerCase(s.charAt(i));
            
            if( upper[upCase-'A'] == lower[loCase-'a'] ) 
                continue;
            
            String s1 = longestNiceSubstring( s.substring(0, i) );
            String s2 = longestNiceSubstring( s.substring(i+1, n) );
            
            return s2.length() > s1.length() ? s2 : s1;
        }
        return s;
    }
}
// class Solution {
//     public String longestNiceSubstring(String s) {
//         int n = s.length();
//         int ansStart = -1, ansEnd = -1;
        
        
//         for(int i=0; i<n; i++) {
//             boolean[] upper = new boolean[26];
//             boolean[] lower = new boolean[26];
            
//             for(int j=i; j<n; j++) {
                
//                 char c = s.charAt(j);
//                 if( c >= 'A' && c <= 'Z' )
//                     upper[c-'A'] = true;
//                 else
//                     lower[c-'a'] = true;               
                
//                 if( i == j ) continue;
                
//                 boolean isNice = true;
//                 for(int k=0; k<26; k++)
//                     if( upper[k] != lower[k] ) {
//                         isNice = false;
//                         break;
//                     }
                
//                 if( isNice && (j-i) > (ansEnd-ansStart) ) {
//                     ansStart = i;
//                     ansEnd = j;
//                 }
//             }
//         }
//         return ansStart == -1 ? "" : s.substring(ansStart, ansEnd+1);
//     }
// }
