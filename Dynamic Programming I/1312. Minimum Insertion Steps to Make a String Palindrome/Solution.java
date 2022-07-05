class Solution {
    public int minInsertions(String s) {
        return s.length() - lps(s);
    }
    
    private int lps(String str) {
        int n = str.length();
        int[] prev = new int[n+1];
                
        for(int i=1; i<=n; i++) {
            int[] curr = new int[n+1];
            for(int j=1; j<=n; j++) {
                if( str.charAt(i-1) == str.charAt(n-j) ) 
                    curr[j] = prev[j-1] + 1;
                else
                    curr[j] = Math.max(curr[j-1], prev[j]);
            }
            prev = curr;
        }
        return prev[n];
    }
}
