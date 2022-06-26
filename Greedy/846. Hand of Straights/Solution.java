class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if( hand.length % groupSize != 0 )
            return false;
        
        TreeMap<Integer,Integer> counts = new TreeMap();
        
        for(int val : hand)
            counts.put(val, counts.getOrDefault(val, 0) + 1);
        
        while( !counts.isEmpty() ) {
            int val = counts.firstKey();
            int cnt = counts.get(val);
            counts.remove(val);
            
            if( cnt == 0 ) continue;
            
            for(int i=1; i<groupSize; i++) {
                int currCnt = counts.getOrDefault(val+i, 0);
                
                if( currCnt < cnt ) 
                    return false;
                
                if( currCnt == cnt )
                    counts.remove( val+i );
                else 
                    counts.put(val+i, currCnt - cnt);
            }
        }
        return true;
    }
}
