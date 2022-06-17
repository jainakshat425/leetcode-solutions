class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstring(0, s.length(), k, s);
    }
    
    private int longestSubstring(int start, int end, int k, String s) {
        if( end < k )
            return 0;
        int[] count = new int[26];
        
        for(int i=start; i<end; i++)
            count[s.charAt(i)-'a'] += 1;
        
        for(int mid=start; mid<end; mid++) {
            if( count[s.charAt(mid)-'a'] >= k )
                continue;
            
            int midNext = mid+1;
            while( midNext < end && count[s.charAt(midNext)-'a'] < k )
                midNext++;
            
            return Math.max(
                longestSubstring(start, mid, k, s), 
                longestSubstring(midNext, end, k, s)
            );
        }
        return end-start;
    }
}
