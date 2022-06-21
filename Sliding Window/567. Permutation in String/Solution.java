class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        if( n > m ) return false;
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int matches = 0;
    
        for(int i=0; i<n; i++) {
            s1Count[s1.charAt(i)-'a'] += 1;
            s2Count[s2.charAt(i)-'a'] += 1;
        }
        
        for(int i=0; i<26; i++)
            matches += (s1Count[i] == s2Count[i]) ? 1 : 0;
            
        int left = 0;
        for(int right=n; right<m; right++) {
            if( matches == 26 )
                return true;
            
            int ind = s2.charAt(right) - 'a';
            s2Count[ind] += 1;
            
            if( s2Count[ind] == s1Count[ind] )
                matches++;
            else if( s2Count[ind] - 1 == s1Count[ind] )
                matches--;
            
            ind = s2.charAt(left) - 'a';
            s2Count[ind] -= 1;
            
            if( s2Count[ind] == s1Count[ind] )
                matches++;
            else if( s2Count[ind] + 1 == s1Count[ind] )
                matches--;
            left++;
        }
        return matches == 26;
    }
}
// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         int n = s1.length();
//         int m = s2.length();
//         int[] s1Count = new int[26];
//         int[] s2Count = new int[26];
//         int left = 0;
//         int matched = 0;
//         int required = 0;
    
//         for(int i=0; i<n; i++) {
//             int charInd = s1.charAt(i)-'a';
//             if( s1Count[charInd] == 0 )
//                 required++;
//             s1Count[charInd] += 1;
//         }
        
//         for(int right=0; right<m; right++) {
//             int charInd = s2.charAt(right) - 'a';
            
//             if( s1Count[charInd] == 0 ) {
//                 Arrays.fill(s2Count, 0);
//                 left = right+1;
//                 matched = 0;
//                 continue;
//             }
            
//             s2Count[charInd] += 1;
            
//             if( s2Count[charInd] > s1Count[charInd] )
//                 matched--;
            
//             while( s2Count[charInd] > s1Count[charInd] ) {
//                 int leftCharInd = s2.charAt(left) - 'a';
                
//                 if( s2Count[leftCharInd] == s1Count[leftCharInd] ) 
//                     matched--;
                
//                 s2Count[leftCharInd] -= 1;
//                 left++;
//             }
            
//             if( s2Count[charInd] == s1Count[charInd] )
//                 matched++;
            
//             if( matched == required )
//                 return true;
//         }
//         return false;
//     }
// }
// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         int n = s1.length();
//         int m = s2.length();
//         Map<Character,Integer> s1Count = new HashMap();
//         Map<Character,Integer> s2Count = new HashMap();
//         int left = 0;
//         int matched = 0;
//         int required = 0;
        
    
//         for(int i=0; i<n; i++) {
//             char c = s1.charAt(i);
//             s1Count.put(c, s1Count.getOrDefault(c, 0)+1);
//         }
//         required = s1Count.size();
        
//         for(int right=0; right<m; right++) {
//             char c = s2.charAt(right);
//             int count1 = s1Count.getOrDefault(c, -1);
            
//             if( count1 == -1 ) {
//                 s2Count.clear();
//                 left = right+1;
//                 matched = 0;
//                 continue;
//             }
            
//             int count2 = s2Count.getOrDefault(c, 0) + 1;
//             s2Count.put(c, count2);
            
//             if( count2 > count1 )
//                 matched--;
            
//             while( s2Count.get(c) > count1 ) {
//                 char leftChar = s2.charAt(left);
//                 int leftCount = s2Count.get(leftChar);
                
//                 if( leftCount == s1Count.get(leftChar) ) 
//                     matched--;
                
//                 s2Count.put(leftChar, leftCount-1);
//                 left++;
//             }
            
//             if( s2Count.get(c) == count1 )
//                 matched++;
            
//             if( matched == required )
//                 return true;
//         }
//         return false;
//     }
// }
