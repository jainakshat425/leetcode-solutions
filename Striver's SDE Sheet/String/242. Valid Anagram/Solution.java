class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
		/* If length of the strings are not equal, then return false */
        if( sLen != tLen ) {
            return false;
        }
        
        Map<Character,Integer> map = new HashMap();
        
		/* Store count of each character present in string (s) */
        for(int i=0; i<sLen; i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        
		/* For each character in (t), subtract the count in map, if some count is already 0, 
		then the strings are not anagram, return false */
        for(int i=0; i<tLen; i++) {
            char curr = t.charAt(i);
            int count = map.getOrDefault(curr, 0);
            
            if( count == 0 ) {
                return false;
            } 
            map.put(curr, count-1);
        }
        return true;
    }
}
