class Solution {
	public String getPermutation(int n, int k) {
        /* Each index stores the number of permutations that can be
        formed by that index number, only permutations till (n-1)th 
        index is required */
        int[] fact = factorialTillN( n-1 );
        
        // Stores number from 1 to n
        List<Integer> num = numbersTillN( n );
        
        // Result will be added into the string
        StringBuilder ans = new StringBuilder();
        
        // Start with the number of permutations for (n-1)
        int factIdx = n-1;
        
        // 1st permutation will be found at 0, 2nd at 1 and so on
        k = k-1;
        
        while( !num.isEmpty() ) {
            // Find the number to be selected
            int index = k / fact[factIdx];
                        
            // Place the current number into ans
            ans.append( num.get( index ) );
            
            // Remove the number placed 
            num.remove( index );
            
            // Next permutation to find
            k = k % fact[factIdx];
            
            // Move to the next factorial index
            factIdx--;
        }
        
        return ans.toString();
    }
    
    private int[] factorialTillN(int n) {
        int[] fact = new int[n];
        fact[0] = 1;
        
        for(int i=1; i<=n; i++) {
            fact[i] = fact[i-1] * i;
        }
        return fact;
    }
    
    private List<Integer> numbersTillN(int n) {
        List<Integer> num = new ArrayList<Integer>();
        
        for(int i=0; i<n; i++) {
            num.add( i+1 );
        }
        return num;
    }
}

/*
class Solution {
	public String getPermutation(int n, int k) {
		int[] num = new int[n];

		for(int i=0; i<n; i++) {
			num[i] = i+1;
		}

		for(int i=1; i<k; i++) {
			nextPermutation(num, n);
		}

		return numArrayToString(num, n);
	}

	private String numArrayToString(int[] num, int n) {
        StringBuilder str = new StringBuilder();
		for(int i=0; i<n; i++) {
			str.append(num[i]);
		}
		return str.toString();
	}

	private void nextPermutation(int[] num, int n) {

		int pivot = findPivotIndex( num, n );

		if( pivot == -1 ) return;

		int higherNumIdx = findHigherNumberInSuffix( num, n, pivot );

		if( higherNumIdx == -1 ) return;

		swap( num, pivot, higherNumIdx );

		reverse(num, pivot+1, n-1);
	}

	private void reverse(int[] num, int left, int right) {
		while(left < right) {
			swap( num, left, right );
			left++;
			right--;
		}
	}

	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	private int findHigherNumberInSuffix(int[] num, int n, int pivot) {
		for(int i = n-1; i >= 0; i--) {
			if( num[i] > num[pivot] ) {
				return i;
			}
		}
		return -1;
	}

	private int findPivotIndex(int[] num, int n) {
		for(int i = n-1; i > 0; i--) {
			if( num[i] > num[i-1] ) {
				return i-1;
			}
		}
		return -1;
	}
}
*/
