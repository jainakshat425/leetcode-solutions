class Solution {
    public int[] restoreArray(int[][] adjPairs) {
        Map<Integer,ArrayList<Integer>> adj = new HashMap();
        int start = adjPairs[0][0];
        
        for(int[] pair : adjPairs) {
            adj.putIfAbsent(pair[0], new ArrayList());
            adj.putIfAbsent(pair[1], new ArrayList());
            
            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }
        
        for(int key : adj.keySet())
            if( adj.get(key).size() == 1 ) {
                start = key;
                break;
            }

        Set<Integer> visited = new HashSet();
        int[] ans = new int[adjPairs.length+1];
        
        dfs(start, new int[]{0}, ans, visited, adj);
        
        return ans;
    }
    
    private void dfs(int u, int[] i, int[] ans, Set<Integer> visited, Map<Integer,ArrayList<Integer>> adj) {
        
        ans[i[0]++] = u;
        visited.add( u );
        
        for(int v : adj.get(u))
            if( !visited.contains(v) )
                dfs(v, i, ans, visited, adj);
    }
}
// class Solution {
//     public int[] restoreArray(int[][] adjPairs) {
//         /* 
//         [-3,1] [-2,4] [1,4]
        
//         -3 1
//         */
//         Map<Integer,Integer> pairMap = new TreeMap();
//         for(int[] pair : adjPairs) {
//             if( pair[0] > pair[1] )
//                 swap(pair, 0, 1);
//             pairMap.put(pair[0], pair[1]);
//         }
        
//         Set<Integer> visited = new HashSet(){{ add(null); }};
//         List<Integer> ans = new ArrayList();
        
//         for(int key : pairMap.keySet()) {
//             if( visited.contains(key) )
//                 continue;
            
//             ans.add( key );
            
//             while( visited.add( pairMap.get(key) )) {
//                 visited.add( key );
                
//                 int val = pairMap.get(key); 
                
//                 ans.add( val );
//                 visited.add( val );
                
//                 key = val;
//             }
//         }
        
//         int[] ansArr = new int[ans.size()];
//         for(int i=0; i<ans.size(); i++)
//             ansArr[i] = ans.get(i);
//         return ansArr;
//     }
    
//     private void swap(int[] arr, int i, int j) {
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }
// }
