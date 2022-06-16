class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        // -1 : Not seen, -2 : Duplicate found, >=0 : Index where seen
        int[] seen = new int[26];
        Arrays.fill(seen, -1);
        
        for(int i=0; i<n; i++) {
            int charInd = s.charAt(i) - 'a';
            seen[charInd] = seen[charInd] == -1 ? i : -2;
        }
        
        int ans = Integer.MAX_VALUE;
        for(int ind : seen) {
            if( ind >= 0 )
                ans = Math.min(ans, ind);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
