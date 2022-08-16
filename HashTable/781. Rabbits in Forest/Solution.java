class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> seen = new HashMap();
        int ans = 0;
        
        for(int cnt : answers) {
            if( cnt == 0 )
                ans += 1;
            else {
                int num = seen.getOrDefault(cnt, 0);
                
                if( num == 0 ) {
                    ans += cnt + 1;
                    seen.put( cnt, cnt );
                } else
                    seen.put( cnt, num-1 );
            }
        }
        return ans;
    }
}
