class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        
        if( n < k )
            return 0;
        
        int totalUnique = countUnique(s, n);
        int ans = 0;
        
        for(int maxUnique=1; maxUnique<=totalUnique; maxUnique++) {
            int left = 0, curUnique = 0, countMoreThanK = 0;
            int[] count = new int[26];
            
            for(int right=0; right<n; right++) {
                int rInd = s.charAt(right) - 'a';
                count[rInd]++;
                
                if( count[rInd] == 1 ) 
                    curUnique++;
                
                if( count[rInd] == k )
                    countMoreThanK++;
                
                while( curUnique > maxUnique ) {
                    int lInd = s.charAt(left++) - 'a';
                    
                    if( count[lInd] == k )
                        countMoreThanK--;
                    
                    count[lInd]--;
                    
                    if( count[lInd] == 0 )
                        curUnique--;
                }
                
                if( countMoreThanK == curUnique )
                    ans = Math.max(ans, right-left+1);
            }
        }
        return ans;
    }
    
    private int countUnique(String s, int n) {
        boolean[] seen = new boolean[26];
        int unique = 0;
        
        for(int i=0; i<n; i++) {
            if(seen[s.charAt(i)-'a']) continue;
            
            seen[s.charAt(i)-'a'] = true;
            unique++;
        }
        return unique;
    }
}
// class Solution {
//     public int longestSubstring(String s, int k) {
//         return longestSubstring(0, s.length(), k, s);
//     }
    
//     private int longestSubstring(int start, int end, int k, String s) {
//         if( end < k )
//             return 0;
//         int[] count = new int[26];
        
//         for(int i=start; i<end; i++)
//             count[s.charAt(i)-'a'] += 1;
        
//         for(int mid=start; mid<end; mid++) {
//             if( count[s.charAt(mid)-'a'] >= k )
//                 continue;
            
//             int midNext = mid+1;
//             while( midNext < end && count[s.charAt(midNext)-'a'] < k )
//                 midNext++;
            
//             return Math.max(
//                 longestSubstring(start, mid, k, s), 
//                 longestSubstring(midNext, end, k, s)
//             );
//         }
//         return end-start;
//     }
// }
