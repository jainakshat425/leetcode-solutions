class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> ans = new ArrayList();
        
        if( pLen > sLen ) return ans;
        
        int[] countP = countChars(p, 0, pLen-1);
        int[] countS = countChars(s, 0, pLen-2);
        
        for(int left=0, right=pLen-1; right<sLen; left++, right++) {
            countS[s.charAt(right)-'a'] += 1;
            
            if( Arrays.equals(countS, countP) )
                ans.add(left);
            
            countS[s.charAt(left)-'a'] -= 1;
        }
        return ans;
    }
    
    private int[] countChars(String s, int start, int end) {
        int[] count = new int[26];
        
        for(int i=start; i<=end; i++) 
            count[s.charAt(i)-'a'] += 1;
        
        return count;
    }
}
