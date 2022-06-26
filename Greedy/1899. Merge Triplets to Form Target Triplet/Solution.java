class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        Set<Integer> found = new HashSet();
        
        for(int[] triplet : triplets) {
            
            if( 
                triplet[0] > target[0] ||
                triplet[1] > target[1] ||
                triplet[2] > target[2] 
            ) continue;
            
            for(int i=0; i<3; i++) 
                if( triplet[i] == target[i] )
                    found.add(i);
            
            if( found.size() == 3 )
                return true;
        }
        return false;
    }
}
