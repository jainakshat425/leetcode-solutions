class Solution {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int combs = 1 << n;
        int ans = 0;
        
        for(int comb=0; comb<combs; comb++) {
            // count num of 1's in n lsb of current combination
            int cnt = count1s(comb, n);
            // check n lsb of current combination
            if( cnt > ans && valid(comb, n, statements) ) 
                ans = cnt;
        }

        return ans;
    }
        
    private int count1s(int num, int n) {
        int cnt = 0;
        for(int i=0; i<n; i++) 
            if( (num & (1 << i)) > 0 )
                cnt++;
        return cnt;
    }
    
    private boolean valid(int comb, int n, int[][] statements) {
        for(int i=0; i<n; i++) {
            if( !isGood(comb, i) )
                continue;
            
            for(int j=0; j<n; j++) {
                if( statements[i][j] == 2 )
                    continue;
                
                boolean good = isGood(comb, j);
                if( statements[i][j] == 1 && !good )
                    return false;
                
                if( statements[i][j] == 0 && good )
                    return false;
            }
        }
        return true;
    }
    
    private boolean isGood(int comb, int i) {
        return (comb & (1 << i)) > 0;
    }
}
