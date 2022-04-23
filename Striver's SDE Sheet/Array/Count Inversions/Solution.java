public class Solution {
    public static long getInversions(long arr[], int n) {
        // Write your code here.
		return mergeSort(arr, 0, n-1);
    }

	private static long mergeSort(long[] arr, int start, int end) {
		long inversions = 0;
		if( end > start ) {
			int mid = start + (end-start)/2;
			
			inversions += mergeSort(arr, start, mid);
			inversions += mergeSort(arr, mid+1, end);
			
			inversions += merge(arr, start, mid, end);
		}
		return inversions;
	}
	
	private static long merge(long[] arr, int start, int mid, int end) {
		int n1 = mid - start + 1;
		int n2 = end - mid;
		
		long[] arr1 = new long[n1];
		long[] arr2 = new long[n2];
		
		for(int i=0; i<n1; i++) {
			arr1[i] = arr[start+i];
		}
		
		for(int i=0; i<n2; i++) {
			arr2[i] = arr[mid+i+1];
		}
		
		int i=0, j=0, k=start;
		long inversions = 0;
		
		while( i < n1 && j < n2 ) {
			
			if( arr2[j] < arr1[i] ) {
				
				arr[k] = arr2[j];
				j++;
				
				inversions += n1-i;
				
			} else {
				arr[k] = arr1[i];
				i++;
			}
			k++;
		}
		
		while( i < n1 ) {
			arr[k] = arr1[i];
			i++;
			k++;
		}
		while( j < n2 ) {
			arr[k] = arr2[j];
			j++;
			k++;
		}
		
		return inversions;
	}
}













