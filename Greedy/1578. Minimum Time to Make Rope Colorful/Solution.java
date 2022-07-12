class Solution {
    public int minCost(String colors, int[] cost) {
        int n = colors.length();
        int ans = 0, maxCost = 0;
        
        for(int i=0; i<n; i++) {
            if( i > 0 && colors.charAt(i) != colors.charAt(i-1) )
                maxCost = 0;
            
            ans += Math.min(maxCost, cost[i]);
            maxCost = Math.max(maxCost, cost[i]);
        }
        return ans;
    }
}
// class Solution {
//     public int minCost(String colors, int[] neededTime) {
//         int n = colors.length();
//         int ans = 0;
//         for(int i=1; i<n; i++) {
//             if( colors.charAt(i) == colors.charAt(i-1) ) {
//                 if( neededTime[i] < neededTime[i-1] ) {
//                     ans += neededTime[i];
//                     neededTime[i] = neededTime[i-1];
//                 } else 
//                     ans += neededTime[i-1];
//             }
//         }
//         return ans;
//     }
// }
