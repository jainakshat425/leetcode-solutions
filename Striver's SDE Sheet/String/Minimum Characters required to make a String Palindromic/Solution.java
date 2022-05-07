public class Solution {
    public int solve(String A) {
        int n = A.length();

        if( n == 0 || n == 1 ) return 0;

        String str = A + '$' + strReverse( A );

        int strLen = str.length();

        int[] lps = computeLPS(str, strLen);

        return n - lps[strLen-1];
    }

    private String strReverse(String str) {
        int n = str.length();
        StringBuilder builder = new StringBuilder();

        for(int i=n-1; i>=0; i--) {
            builder.append( str.charAt(i) );
        }
        return builder.toString();
    }

    private int[] computeLPS(String str, int n) {
        int[] lps = new int[n];
        int i = 1;
        int len = 0;

        while( i < n ) {

            if( str.charAt(i) == str.charAt(len) ) {
                lps[i++] = ++len;
            } else {
                if( len != 0) {
                    len = lps[len-1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }
}
