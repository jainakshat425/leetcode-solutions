class Solution {
    public int minDeletions(String s) {
        int n = s.length();
        int[] count = new int[26];
        int ans = 0;
        int maxAllowedCnt = n;
        
        for(int i=0; i<n; i++)
            count[s.charAt(i) - 'a'] += 1;
        
        Arrays.sort(count);
        
        for(int i=25; i>=0 && count[i] > 0; i--) {            
            if( count[i] > maxAllowedCnt ) {
                ans += count[i] - maxAllowedCnt;
                count[i] = maxAllowedCnt;
            }
            if( maxAllowedCnt > 0)
                maxAllowedCnt = count[i]-1;
        }
        return ans;
    }
}
/* 
class Solution {
    public int minDeletions(String s) {
        int n = s.length();
        int[] count = new int[26];
        Set<Integer> seen = new HashSet();
        int ans = 0;
        
        for(int i=0; i<n; i++)
            count[s.charAt(i) - 'a'] += 1;
        
        for(int cnt : count) {            
            while( cnt > 0 && seen.contains(cnt) ) {
                cnt--;
                ans++;
            }
            seen.add( cnt );
        }
        return ans;
    }
}
*/
