class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n+1];
        
        for(int[] e : trust) {
            in[e[0]] = -1;
            if( in[e[1]] != -1 )
                in[e[1]] += 1;
        }
        
        for(int i=1; i<=n; i++)
            if( in[i] == n-1 )
                return i;
        
        return -1;
    }
}
// class Solution {
//     public int findJudge(int n, int[][] trust) {
//         int[] in = new int[n+1];
//         int[] out = new int[n+1];
        
//         for(int[] e : trust) {
//             out[e[0]] += 1;
//             in[e[1]] += 1;
//         }
        
//         for(int i=1; i<=n; i++)
//             if( out[i] == 0 && in[i] == n-1 )
//                 return i;
        
//         return -1;
//     }
// }
