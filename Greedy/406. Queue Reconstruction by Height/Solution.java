class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        List<int[]> ans = new ArrayList();

        // Sort by decreasing h, if equal sort by increasing k
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        for(int[] p : people) 
            ans.add(p[1], p);
        
        return ans.toArray(new int[n][2]);
    }
}
// class Solution {
//     public int[][] reconstructQueue(int[][] people) {
//         int n = people.length;
//         int[][] ans = new int[n][];
        
//         // Sort in increasing order of height
//         Arrays.sort(people, (a,b) -> a[0] - b[0]);
        
//         for(int[] p : people) {
//             int h = p[0];
//             int k = p[1];
                        
//             for(int i=0; i<n; i++) {
//                 if( k == 0 ) {
//                     while( ans[i] != null )
//                         i++;
                    
//                     ans[i] = p;
//                     break;
//                 }
            
//                 if( ans[i] == null || ans[i][0] == p[0] )
//                     k--;
//             }
//         }
        
//         return ans;
//     }
// }
