class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        
        for(int i=0; i<n; i++) {
            count += countPalindromes(s, i, i);
            count += countPalindromes(s, i, i+1);
        }
        
        return count;
    }
    
    private int countPalindromes(String str, int start, int end) {
        int count = 0;
        while( start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end) ) {
            count++;
            start--;
            end++;
        }
        return count;
    }
}
