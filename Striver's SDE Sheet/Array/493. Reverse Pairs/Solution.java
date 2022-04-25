class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        
        return modifiedMergeSort(nums, 0, n-1);
    }
    
    private int modifiedMergeSort(int[] nums, int start, int end) {
        int pairs = 0;
        if( start < end ) {
            int mid = start + (end-start)/2;
            
            pairs += modifiedMergeSort(nums, start, mid);
            pairs += modifiedMergeSort(nums, mid+1, end);
            
            pairs += merge(nums, start, mid, end);
        }
        
        return pairs;
    }
    
    private int merge(int[] nums, int start, int mid, int end) {
        
        int n1 = mid+1-start;
        int n2 = end-mid;
        
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        
        // Copy left half of the {nums} array into {arr1}
        arrayCopy(nums, start, mid, arr1);
        
        // Copy right half of the {nums} array into {arr2}
        arrayCopy(nums, mid+1, end, arr2);
        
        int i=0, j=0;
        
        // Before merging the arrays count the reverse pairs
        int pairs = 0;
        
        while( i < n1 && j < n2 ) {
            
            if( (long)arr1[i] > (long)arr2[j] * 2 ) {
                // All the numbers after {i} till {n1-1} will satisfy the above condition
                pairs += n1 - i;
                
                // Move {j} pointer to check if current {i} is greater than next number of {arr2} 
                j++;
            } else {
                // Check if the next number is twice of number at {j}
                i++;
            }
        }
          
        // Reset i and j to 0 before starting the merge
        i = 0;
        j = 0;
        
        while( i < n1 && j < n2 ) {
            
            if( arr2[j] < arr1[i] ) {
                nums[start] = arr2[j++];

            } else {
                nums[start] = arr1[i++];
            }
            start++;
        }
        
        while( i < n1 ) {
            nums[start++] = arr1[i++];
        }
        
        while( j < n2 ) {
            nums[start++] = arr2[j++];
        }
        
        return pairs;
    }
    
    private void arrayCopy(int[] src, int start, int end, int[] dest) {
        
        int j = 0;
        
        for(int i=start; i<=end; i++) {
            dest[j] = src[i];
            j++;
        }
    }
}
