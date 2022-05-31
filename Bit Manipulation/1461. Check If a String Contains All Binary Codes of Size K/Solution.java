class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int permutations = 1 << k;
        int allOne = permutations - 1;
        boolean[] found = new boolean[permutations];
        int hashVal = 0;
        
        for(int i=0; i<n; i++) {
            hashVal = ((hashVal << 1) & allOne) | (s.charAt(i)-'0');

            if( i >= k-1 && !found[hashVal] ) {
                found[hashVal] = true;
                
                if( --permutations == 0 )
                    return true;
            }
        }
        return false;
    }
}
/*
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int permutations = 1 << k;
	    int n = s.length();
    	Set<String> set = new HashSet();

        for(int i=k; i<=n; i++) {
            set.add( s.substring(i-k, i) );
            
            if( set.size() == permutations )
                return true;
        }

        return false;
    }
}
*/
