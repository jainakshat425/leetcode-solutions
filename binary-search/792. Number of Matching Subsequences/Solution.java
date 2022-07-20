class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<Integer>[] sInd = new ArrayList[26];
        int ans = 0;
        
        for(int i=0; i<26; i++)
            sInd[i] = new ArrayList();
        
        for(int i=0; i<s.length(); i++)
            sInd[s.charAt(i) - 'a'].add(i);
        
        for(String word : words) 
            if( isSubseq(word, sInd) )
                ans++;
        
        return ans;
    }
    
    private boolean isSubseq(String word, ArrayList<Integer>[] sInd) {
        int lastInd = -1;
        
        for(int i=0; i<word.length(); i++) {
            lastInd = binarySearch(lastInd+1, sInd[word.charAt(i) - 'a']);

            if( lastInd == -1 )
                return false;
        }
        return true;
    }
    
    private int binarySearch(int val, ArrayList<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        int ans = -1;
        while( low <= high ) {
            int mid = low + (high-low)/2;
            int midVal = arr.get(mid);
            
            if( midVal >= val ) {
                ans = midVal;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
}
