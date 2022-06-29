// class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         int[] prices = new int[n];
//         Arrays.fill(prices, Integer.MAX_VALUE);
//         prices[src] = 0;
        
//         for(int i=0; i<=k; i++) {
//             int[] tempPrices = Arrays.copyOf(prices, n);
            
//             for(int[] flight : flights) {
//                 int s = flight[0]; // src
//                 int d = flight[1]; // dest
//                 int p = flight[2]; // price
                
//                 if( prices[s] != Integer.MAX_VALUE && prices[s] + p < tempPrices[d] )
//                     tempPrices[d] = prices[s] + p;
//             }
//             prices = tempPrices;
//         }
        
//         return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
//     }
// }
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList();
        
        for(int i=0; i<n; i++)
            adj.add(new ArrayList());
        
        for(int[] edge : flights)
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        
        int[][] dp = new int[n][k+1];
        
        int ans = dfs(src, dst, k, adj, dp);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private int dfs(int src, int dst, int k, ArrayList<ArrayList<int[]>> adj, int[][] dp) {
        
        if( src == dst )
            return 0;
        
        if( k == -1 )
            return Integer.MAX_VALUE;
        
        if( dp[src][k] != 0 ) return dp[src][k];
        
        int min = Integer.MAX_VALUE;
        
        for(int[] edge : adj.get(src)) {
            
            int cost = dfs(edge[0], dst, k-1, adj, dp);
            
            if( cost == Integer.MAX_VALUE )
                continue;
            
            min = Math.min(min, edge[1] + cost);
        }
        return dp[src][k] = min;
    }
}
