class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26], last = new int[26];
        
        Arrays.fill(first, n);
        
        for(int i=0; i<n; i++) {
            int charInd = s.charAt(i) - 'a';
            first[charInd] = Math.min(first[charInd], i);
            last[charInd] = i;
        }
        
        int ans = 0;
        for(int i=0; i<26; i++)
            if( first[i] < last[i] )
                ans += countUniqueChars(first[i]+1, last[i]-1, s);
        
        return ans;
    }
    
    private int countUniqueChars(int start, int end, String s) {
        boolean[] seen = new boolean[26];
        int cnt = 0;
        
        for(int i=start; i<=end; i++) {
            int charInd = s.charAt(i) - 'a';
            
            if( !seen[charInd] ) {
                cnt++;
                seen[charInd] = true;
            }
        }
        return cnt;
    }
}
