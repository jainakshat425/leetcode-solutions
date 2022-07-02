class Solution {
    public int maxArea(int h, int w, int[] hc, int[] vc) {
        int m = hc.length;
        int n = vc.length;
        
        Arrays.sort(hc);
        Arrays.sort(vc);
        
        int maxHeight = Math.max(hc[0], h - hc[m-1]);
        int maxWidth = Math.max(vc[0], w - vc[n-1]);
        
        for(int i=0; i<m-1; i++) 
            maxHeight = Math.max(maxHeight, hc[i+1]-hc[i]);
        
        for(int i=0; i<n-1; i++) 
            maxWidth = Math.max(maxWidth, vc[i+1]-vc[i]);
        
        return (int)((long)maxHeight*maxWidth % 1000000007);
    }
}
/* 
class Solution {
    public int maxArea(int h, int w, int[] hc, int[] vc) {
        int m = hc.length;
        int n = vc.length;
        
        Arrays.sort(hc);
        Arrays.sort(vc);
        
        int maxHorDist = 0;
        int maxVerDist = 0;
        
        for(int i=0; i<=m; i++) {
            int top = i == 0 ? 0 : hc[i-1];
            int bottom = i < m ? hc[i] : h;
            
            maxHorDist = Math.max(maxHorDist, bottom-top);
        }
        for(int j=0; j<=n; j++) {
            int left = j == 0 ? 0 : vc[j-1];
            int right = j < n ? vc[j] : w;
            
            maxVerDist = Math.max(maxVerDist, right-left);
        }
        
        return (int)multiplyWithMod(maxHorDist, maxVerDist, 1e9 + 7);
    }
    
    private double multiplyWithMod(int a, int b, double m) {
        if( b == 0 ) 
            return 0;
        
        double ans = multiplyWithMod(a, b/2, m);
        
        if( b%2 == 0 )
            return (ans%m + ans%m)%m;
        else
            return (ans%m + ans%m + a)%m;
    }
}
*/
// class Solution {
//     public int maxArea(int h, int w, int[] hc, int[] vc) {
//         /* 
//         h = 5 w = 4
        
//         hc = [1,2,4] vc = [1,3]
        
//         top = 0, left = 0
        
//         hc[0] - top * vc[0] - left
//         left = vc[0]
//         hc[0] - top * vc[1] - left
//         left = vc[1]
//         hc[0] - top * right - left
        
//         top = hc[0]
//         */
//         int m = hc.length;
//         int n = vc.length;
        
//         Arrays.sort(hc);
//         Arrays.sort(vc);
        
//         int max = 0;
//         int top = 0;
        
//         for(int i=0; i<=m; i++) {
//             int bottom = i < m ? hc[i] : h;
//             int left = 0;
            
//             for(int j=0; j<=n; j++) {
//                 int right = j < n ? vc[j] : w;
//                 max = Math.max(max, (bottom - top) * (right - left));
//                 left = right;
//             }
//             top = bottom;
//         }
//         return max;
//     }
// }
