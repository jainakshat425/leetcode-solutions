class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> freq = new HashMap();
        // num of subseq ending at index num
        Map<Integer,Integer> ends = new HashMap();
        
        for(int num : nums)
            mapModifyValueBy(freq, num, 1);
        
        for(int num : nums) {
            if( mapGet(freq, num) == 0 )
                continue;
            mapModifyValueBy(freq, num, -1);
            
            // If a subseq ends prev num, append curr num
            // to subseq ending at prev num
            if( mapGet(ends, num-1) > 0 ) {
                mapModifyValueBy(ends, num-1, -1);
                mapModifyValueBy(ends, num, 1);
            }
            // start new subseq from curr num if next two nums are present
            else if( mapGet(freq, num+1) > 0 && mapGet(freq, num+2) > 0) {
                mapModifyValueBy(freq, num+1, -1);
                mapModifyValueBy(freq, num+2, -1);
                mapModifyValueBy(ends, num+2, 1);
            }
            else return false;
        }
        return true;
    }
    
    private int mapGet(Map<Integer,Integer> map, int key) {
        return map.getOrDefault(key, 0);
    }
    private void mapModifyValueBy(Map<Integer,Integer> map, int key, int val) {
        map.put(key, mapGet(map, key) + val);
    }
}
