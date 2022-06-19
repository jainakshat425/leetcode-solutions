class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] charToCount = new int[26];
        int left = 0;
        int ans = 0;
        int maxFreq = 0;
        
        for(int right=0; right<n; right++) {
            char rChar = s.charAt(right);
            
            charToCount[rChar - 'A'] += 1;
            
            maxFreq = Math.max(maxFreq, charToCount[rChar - 'A']);
            int windowSize = right-left + 1;
            
            while( windowSize - maxFreq > k ) {
                char lChar = s.charAt(left);
                charToCount[lChar - 'A'] -= 1;
                left++;
                windowSize = right-left + 1;
            }
            
            ans = Math.max(ans, windowSize);
        }
        return ans;
    }
}
