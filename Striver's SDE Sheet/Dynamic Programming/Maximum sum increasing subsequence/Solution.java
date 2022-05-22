class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    int[] dp = new int[n+1];
	    
	    for(int ind=n-1; ind>=0; ind--) {

	        for(int prevInd=ind-1; prevInd>=-1; prevInd--) {
	            
	            int notTake = dp[prevInd+1];
	            
        	    int take = 0;
        	    if( prevInd == -1 || arr[ind] > arr[prevInd] )
        	        take = arr[ind] + dp[ind+1];
        	        
        	    dp[prevInd+1] = Math.max( take, notTake );
	        }
	    }
	    return dp[0];
	}  
}
