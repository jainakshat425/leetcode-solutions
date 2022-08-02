class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet();
        int ans = 0;
        
        for(int i=0; i<jewels.length(); i++) 
            jewelSet.add( jewels.charAt(i) );
        
        for(int i=0; i<stones.length(); i++)
            if( jewelSet.contains(stones.charAt(i)) )
                ans++;
        return ans;
    }
}
