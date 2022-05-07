class Solution {
    
    private static final int HASH_NUM = 3;
    
    public int repeatedStringMatch(String a, String b) {
        int n = b.length();
        int ans = 1;
        
        StringBuilder str = new StringBuilder();
        str.append( a );
        
        // Repeat the string (a) until its length become greater than or equal to pattern (b)
        while( str.length() < n ) {
            str.append( a );
            ans++;
        }
        
        // Check if pattern (b) exist in the repeated string
        if( rabinKarp(str.toString(), b) ) return ans;
        
        /* Append string (a) one more time to cover the cases of slit string
        and check if pattern (b) exist in the repeated string */
        str.append( a );
        if( rabinKarp(str.toString(), b) ) return ans+1;
        
        return -1;
    }
    
    private boolean rabinKarp(String str, String pat) {
        int strLen = str.length();
        int patLen = pat.length();
        
        int patHash = createHashValue(pat, patLen);
        int strHash = createHashValue(str, patLen);
                
        // Repeat for each pattern length window in string
        for(int i=0; i<=strLen-patLen; i++) {

            /* If hash value of current window in the string matches with the
            pattern hash value. then only check if each character of current 
            window matches with pattern */
            if( strHash == patHash ) {
                boolean match = true;
                
                for(int j=0; j<patLen; j++) {
                    if( str.charAt(i+j) != pat.charAt(j) ) {
                        match = false;
                        break;
                    }
                }
                
                if( match ) return true;
            }
            
            /* If is not in the last window, remove first character from current window
            and append next character from end and recalculate hash */
            if( i < strLen-patLen) {
                strHash = recalculateHash(str, i, i+patLen, strHash, patLen);
            }
        }
        
        return false;
    }
    
    private int createHashValue(String str, int n) {
        int hash = 0;
        for(int i=0; i<n; i++) {
            hash += str.charAt(i) * Math.pow(HASH_NUM, i);
        }
        return hash;
    }
    
    private int recalculateHash(String str, int oldIdx, int newIdx, int oldHash, int patLength) {
        int newHash = oldHash - str.charAt( oldIdx );
        newHash /= HASH_NUM;
        newHash += str.charAt( newIdx ) * Math.pow(HASH_NUM, patLength-1);
        return newHash;
    }
}
