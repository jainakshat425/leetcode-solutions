class Solution {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        
        Arrays.sort(cuts);
        
        int[][] dp = new int[len][len];
        
        for(int i=len-1; i>=0; i--) {
            for(int j=i; j<len; j++) {
                
                int start = i == 0 ? 0 : cuts[i-1];
                int end = j == len-1 ? n : cuts[j+1];
                int cost = end - start;
                int min = Integer.MAX_VALUE;

                for(int ind=i; ind<=j; ind++) {

                    int left = ind == 0 ? 0 : dp[i][ind-1];
                    int right = ind == len-1 ? 0 : dp[ind+1][j];

                    min = Math.min(min, cost + left + right);
                }

                dp[i][j] = min;
            }
        }
        
        return dp[0][len-1];
    }
}
/* 
class Solution {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        List<Integer> cuts1 = new ArrayList(len+2) {{
            add(0);
            add(n);
        }};
        
        for(int cut : cuts) 
            cuts1.add( cut );
        
        Collections.sort(cuts1);
        
        int[][] dp = new int[len+2][len+2];
        
        for(int i=len; i>=1; i--) {
            for(int j=i; j<=len; j++) {
                
                int cost = cuts1.get(j+1) - cuts1.get(i-1);
                int min = Integer.MAX_VALUE;

                for(int ind=i; ind<=j; ind++) {

                    int left = dp[i][ind-1];
                    int right = dp[ind+1][j];

                    min = Math.min(min, cost + left + right);
                }

                dp[i][j] = min;
            }
        }
        
        return dp[1][len];
    }
}
*/
/*
class Solution {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[][] dp = new int[len][len];
        
        Arrays.sort(cuts);
        
        return minCost(0, len-1, len, n, cuts, dp);
    }
    
    private int minCost(int i, int j, int len, int n, int[] cuts, int[][] dp) {
        if( i > j )
            return 0;
        
        if( dp[i][j] != 0 ) return dp[i][j];
        
        int start = i == 0 ? 0 : cuts[i-1];
        int end = j == len-1 ? n : cuts[j+1];
        int cost = end - start;
        
        int min = Integer.MAX_VALUE;
        
        for(int ind=i; ind<=j; ind++) {
            
            int left = minCost(i, ind-1, len, n, cuts, dp);
            int right = minCost(ind+1, j, len, n, cuts, dp);
            
            min = Math.min(min, cost + left + right);
        }
        
        return dp[i][j] = min;
    }
}*/
/*
class Solution {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        List<Integer> cuts1 = new ArrayList(len+2) {{
            add(0);
            add(n);
        }};
        
        for(int cut : cuts) 
            cuts1.add( cut );
        
        Collections.sort(cuts1);
        
        int[][] dp = new int[len+2][len+2];
        
        return minCost(1, len, cuts1, dp);
    }
    
    private int minCost(int i, int j, List<Integer> cuts, int[][] dp) {
        if( i > j )
            return 0;
        
        if( dp[i][j] != 0 ) return dp[i][j];
        
        int cost = cuts.get(j+1) - cuts.get(i-1);
        int min = Integer.MAX_VALUE;
        
        for(int ind=i; ind<=j; ind++) {
            
            int left = minCost(i, ind-1, cuts, dp);
            int right = minCost(ind+1, j, cuts, dp);
            
            min = Math.min(min, cost + left + right);
        }
        
        return dp[i][j] = min;
    }
}*/
