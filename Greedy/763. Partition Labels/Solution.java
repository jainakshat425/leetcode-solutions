class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] charLastInd = new int[26];
        List<Integer> ans = new ArrayList();
        
        for(int i=0; i<n; i++) 
            charLastInd[s.charAt(i) - 'a'] = i;

        int end = 0;
        int len = 0;
        
        for(int i=0; i<n; i++) {   
            len++;
                        
            end = Math.max(end, charLastInd[s.charAt(i) - 'a']);
            
            if( i == end ) {
                ans.add( len );
                len = 0;
            }
        }        

        return ans;
    }
}
