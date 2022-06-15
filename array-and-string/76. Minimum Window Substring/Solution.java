class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        Map<Character,Integer> mapT = new HashMap();
        Map<Character,Integer> mapS = new HashMap();
        
        for(int i=0; i<n; i++) 
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        
        int required = mapT.size();
        int left = 0;
        int matched = 0;
        int min = Integer.MAX_VALUE;
        int ansLeft = -1, ansRight = -1;
        
        for(int right=0; right<m; right++) {
            char cr = s.charAt(right);
            
            if( !mapT.containsKey(cr) )
                continue;
            
            int countSR = mapS.getOrDefault(cr, 0) + 1;
            mapS.put(cr, countSR);
                        
            if( countSR == mapT.get(cr) ) 
                matched++;
                    
            while( matched == required ) {
                int len = right-left+1;
                if( len < min ) {
                    min = len;
                    ansLeft = left;
                    ansRight = right;
                }
                
                char cl = s.charAt(left);
                
                if( mapS.containsKey(cl) ) {
                    int countTL = mapT.get(cl);
                    int countSL = mapS.get(cl) - 1;

                    if( countSL == 0 )
                        mapS.remove(cl);
                    else
                        mapS.put(cl, countSL);

                    if( countSL < countTL )
                        matched--;
                }
                left++;
            }
        }
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight+1);
    }
}
