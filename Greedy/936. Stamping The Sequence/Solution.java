class Solution {
    public int[] movesToStamp(String stamp, String target) {
        int sn = stamp.length(), tn = target.length();
        char[] S = stamp.toCharArray();
        char[] T = target.toCharArray();
        boolean[] visited = new boolean[tn-sn+1];
        List<Integer> inds = new ArrayList();
        int replaced = 0;
        
        while( replaced < tn ) {
            boolean changed = false;
            
            for(int i=0; i<=tn-sn; i++) {
                if( !visited[i] && canReplace(i, T, S) ) {
                    visited[i] = true;
                    replaced += replace(i, sn, T);
                    changed = true;
                    inds.add( i );
                    
                    if( replaced == tn )
                        break;
                }
            }
            
            if( !changed )
                return new int[0];
        }
        
        int n = inds.size();
        int[] ans = new int[n];
        
        for(int i=n-1; i>=0; i--)
            ans[n-i-1] = inds.get(i);
        
        return ans;
    }
    
    private boolean canReplace(int start, char[] T, char[] S) {
        for(int i=0; i<S.length; i++) 
            if( T[start+i] != '?' && T[start+i] != S[i] )
                return false;
        return true;
    }
    
    private int replace(int start, int sn, char[] T) {
        int cnt = 0;
        for(int i=0; i<sn; i++) {
            if( T[start+i] != '?' ) {
                T[start+i] = '?';
                cnt++;
            }
        }
        return cnt;
    }
}
