class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer,HashSet<Integer>> jumpOptions = new HashMap();
                
        for(int i=0; i<n; i++)
            jumpOptions.put(stones[i], new HashSet());
        
        jumpOptions.get(0).add(1);
        
        for(int i=0; i<n; i++) {
            
            for(int jump : jumpOptions.get(stones[i])) {
                int pos = stones[i] + jump;
                
                if( pos == stones[n-1] )
                    return true;
                
                HashSet<Integer> options = jumpOptions.get(pos);
                
                if( options == null ) 
                    continue;
                
                if( jump-1 > 0 )
                    options.add(jump-1);
                options.add(jump);
                options.add(jump+1);
            }
        }
        return false;
    }
}
// class Solution {
//     public boolean canCross(int[] stones) {
//         int n = stones.length;
//         Map<Integer,Integer> posToInd = new HashMap();
//         Boolean[][] dp = new Boolean[n][n];
        
//         for(int i=0; i<n; i++)
//             posToInd.put(stones[i], i);
        
//         return canCross(0, 1, stones, dp, posToInd);
//     }
    
//     public boolean canCross(int pos, int jump, int[] stones, Boolean[][] dp, Map<Integer,Integer> posToInd) {
//         if( jump <= 0 ) 
//             return false;
        
//         if( dp[pos][jump] != null ) 
//             return dp[pos][jump];
        
//         int next = posToInd.getOrDefault(stones[pos] + jump, -1);
        
//         if( next == -1 )
//             return false;
        
//         if( next == stones.length-1 )
//             return true;
        
//         return dp[pos][jump] = canCross(next, jump-1, stones, dp, posToInd) ||
//                                 canCross(next, jump, stones, dp, posToInd) ||
//                                 canCross(next, jump+1, stones, dp, posToInd);
//     }
// }
