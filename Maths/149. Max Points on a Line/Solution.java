class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int max = 0;
        
        for(int i=0; i<n; i++) {
            Map<String,Integer> coprimeToCount = new HashMap();
            
            int x1 = points[i][0];
            int y1 = points[i][1];
            
            for(int j=i+1; j<n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                int dx = x2 - x1;
                int dy = y2 - y1;
                
                int gcd = gcd(dx, dy);
                // System.out.println(slope);
                
                String key;
                if( gcd == 0 )
                    key = "0:0";
                else
                    key = (dx/gcd) + ":" + (dy/gcd);
                
                int count = coprimeToCount.getOrDefault(key, 0) + 1;
                
                coprimeToCount.put(key, count);
                
                max = Math.max(max, count);
            }
        }
        return max+1;
    }
    
    private int gcd(int a, int b) {
        if( b == 0 )
            return a;
        return gcd(b, a%b);
    }
}

// class Solution {
//     public int maxPoints(int[][] points) {
//         int n = points.length;
//         int max = 0;
        
//         for(int i=0; i<n; i++) {
//             Map<Float,Integer> slopeToCount = new HashMap();
                
//             int x1 = points[i][0];
//             int y1 = points[i][1];
            
//             for(int j=i+1; j<n; j++) {
//                 int x2 = points[j][0];
//                 int y2 = points[j][1];
                
//                 float slope = calculateSlope(x1, y1, x2, y2);
//                 System.out.println(slope);
                
//                 int count = slopeToCount.getOrDefault(slope, 0) + 1;
                
//                 slopeToCount.put(slope, count);
                
//                 max = Math.max(max, count);
//             }
//         }
//         return max+1;
//     }
    
//     private float calculateSlope(int x1, int y1, int x2, int y2) {
//         if( x2 - x1 == 0 )
//             return Integer.MAX_VALUE;
//         float slope = (float)(y2 - y1) / (float)(x2 - x1);
//         return Math.abs(slope) == 0 ? 0 : slope;
//     }
// }
