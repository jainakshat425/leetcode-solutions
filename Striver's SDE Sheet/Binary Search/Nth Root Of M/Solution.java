public class Solution {
    public static double findNthRootOfM(int n, long m) {
		if( m < 2 ) {
			return m;
		}
		
		double low = 1, high = m;
		// 
		double threshold = 1e-7;
		
		while( high - low > threshold ) {
			double mid = (high+low)/2;
			// Calculate the nth power of current number (mid)
			double nthPower = Math.pow(mid, n);
			
			if( nthPower < m ) {
				// Check for numbers from mid
				low = mid;
			} else {
				// Check for numbers till mid
				high = mid;
			}
		}
		return low;
    }
}
