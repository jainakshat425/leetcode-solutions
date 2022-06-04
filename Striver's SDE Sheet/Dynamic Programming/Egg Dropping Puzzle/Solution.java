class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
//     static int eggDrop(int eggs, int floors, int[][] dp) 
// 	{
// 	    if( floors == 0 || floors == 1 || eggs == 1 )
// 	        return floors;
	        
// 	    if( dp[eggs][floors] != -1 ) return dp[eggs][floors];
	    
// 	    int min = Integer.MAX_VALUE;
	    
// 	    for(int i=1; i<=floors; i++) {
// 	        int notBreaks = eggDrop(eggs, floors-i, dp);
// 	        int breaks = eggDrop(eggs-1, i-1, dp);
	        
// 	        min = Math.min(min, Math.max(notBreaks,breaks));
// 	    }
// 	    return dp[eggs][floors] = 1+min;
// 	}
	
	static int eggDrop(int n, int k)  {
	    int[][] dp = new int[n+1][k+1];
	    
	    for(int eggs=1; eggs<=n; eggs++) {
	        dp[eggs][0] = 0;
	        dp[eggs][1] = 1;
	    }
	    for(int floors=1; floors<=k; floors++) {
	        dp[1][floors] = floors;
	    }
	    
	    for(int eggs=2; eggs<=n; eggs++) {
	        for(int floors=2; floors<=k; floors++) {
	            int min = Integer.MAX_VALUE;
	    
        	    for(int i=1; i<=floors; i++) {
        	        int notBreaks = dp[eggs][floors-i];
        	        int breaks = dp[eggs-1][i-1];
        	        
        	        min = Math.min(min, Math.max(notBreaks,breaks));
        	    }
        	    dp[eggs][floors] = 1+min;
	        }
	    }
	    return dp[n][k];
	}
}
