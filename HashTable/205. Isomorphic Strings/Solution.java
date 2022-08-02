class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character,Character> s2tMap = new HashMap();
        Map<Character,Character> t2sMap = new HashMap();
        
        for(int i=0; i<n; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            
            if( !s2tMap.containsKey(sc) ) {
                if( t2sMap.containsKey(tc) ) 
                    return false;
                
                s2tMap.put(sc, tc);
                t2sMap.put(tc, sc);
            }
            
            if( s2tMap.get(sc) != tc )
                return false;
        }
        return true;
    }
}
