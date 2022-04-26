class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort( arr );
        Arrays.sort( dep );
        
        int platform = 0, max = 0;
        
        int i = 0, j = 0;
        
        // Repeat for all the arrivals and departure
        while( i < n ) {
            
            // If train is departing before a train arrives
            if( dep[j] < arr[i] ) {
                platform--;
                j++;
            } else {
                // If train is arriving before a train departs
                platform++;
                i++;
                
                max = Math.max(platform, max);
            }
        }
        
        return max;
    }
    
}

