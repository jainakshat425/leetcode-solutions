import java.util.Arrays;

public class Solution {

    public static int chessTournament(int[] positions, int n,  int c) 
	{
		Arrays.sort( positions );
		
		/* Minimum distance can be one and maximum can be one less than
		the highest position */
		int low = 1, high = positions[n-1] - 1;
		int ans = 0;
		
		while( low <= high ) {
			// Check if distance of mid is possible
			int mid = low + (high-low)/2;
			
			if( isDistancePossible(positions, n, c, mid) ) {
				ans = mid;
				// Check for higher distances
				low = mid+1;
			} else {
				/* Since distance of mid is not possible, chec for
				lower distances */
				high = mid-1;
			}
		}
		
		return ans;
    }
	
    private static boolean isDistancePossible(int[] positions, int n,  int c, int distance) {
		int candidate = 1, position = positions[0];
		
		for(int i=1; i<n; i++) {
			
			if( positions[i] - position >= distance ) {
				candidate++;
				position = positions[i];
			}
			
			if( candidate >= c ) {
				return true;
			}
		}
		return false;
	}
}
