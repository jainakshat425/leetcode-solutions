class Solution {
    
    public int countVowelPermutation(int n) {
        int[] prev = new int[5];
        int mod = 1000000007;
        int a = 0, e = 1, i = 2, o = 3, u = 4;
        
        Arrays.fill(prev, 1);
        
        for(int j=1; j<n; j++) {
            int[] curr = new int[5];
            
            curr[a] = ((prev[e] + prev[i]) % mod + prev[u]) % mod;
            curr[e] = (prev[a] + prev[i]) % mod;
            curr[i] = (prev[e] + prev[o]) % mod;
            curr[o] = prev[i];
            curr[u] = (prev[i] + prev[o]) % mod;
            
            prev = curr;
        }
        
        int ans = 0;
        
        for(int val : prev)
            ans = (ans + val) % mod;
        
        return ans;
    }
}
// class Solution {
    
//     public int countVowelPermutation(int n) {
//         int[][] dp = new int[n][5];
//         int mod = 1000000007;
//         int a = 0, e = 1, i = 2, o = 3, u = 4;
        
//         Arrays.fill(dp[0], 1);
        
//         for(int j=1; j<n; j++) {
//             dp[j][a] = ((dp[j-1][e] + dp[j-1][i]) % mod + dp[j-1][u]) % mod;
//             dp[j][e] = (dp[j-1][a] + dp[j-1][i]) % mod;
//             dp[j][i] = (dp[j-1][e] + dp[j-1][o]) % mod;
//             dp[j][o] = dp[j-1][i];
//             dp[j][u] = (dp[j-1][i] + dp[j-1][o]) % mod;
//         }
        
//         int ans = 0;
        
//         for(int val : dp[n-1])
//             ans = (ans + val) % mod;
        
//         return ans;
//     }
// }
