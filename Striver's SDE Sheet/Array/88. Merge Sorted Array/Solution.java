class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if( n==0 ) return;
        
        int i=0;
        
        // Repeat for first {m} numbers in {nums1}
        while( i < m ) {

            // If the current number is greater than the first number in the 2nd array
            if( nums1[i] > nums2[0] ) {

                // Swap the current number with the first number in the 2nd array
                swap(nums1, i, nums2, 0);

                // Place the swapped number in the correct position in the 2nd array so that it remains sorted. 
                fixSortOrder(nums2);

            } else {
                // Move to the next number
                i++;
            }
        }        
        
        int size = nums1.length;
        int j = 0;
        
        // Copy over the elements from the 2nd array into the 1st array
        while( i < size ) {
            nums1[i] = nums2[j];
            i++;
            j++;
        }
    }
    
    private void fixSortOrder(int[] arr) {
        int n = arr.length;
        int curr = 0, next = 1;
        
        while( next < n && arr[curr] > arr[next] ) {
            swap( arr, curr, next );
            curr++;
            next++;
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
                      
    private void swap(int[] arr1, int i, int[] arr2, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
    
    /*
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /* 
        1. Copy the sorted initial subarray from the first subarray num1 to
           a new array arr1, so that manipulation in the nums1 doesn't override
           the elements.
        2. Put pointers on the start of the array arr1 and nums2.
        3. Compare elements at pointer, whichever is smaller will be added to 
           the result nums1.
        4. Repeat step 3 until one of the pointer reaches array length.
        5. If the pointers are not been pointing to the last elements of the 
           subarrays, there must be remaining elements.
        6. Copy them over to the result array nums1.
        /
        
        int[] arr1 = new int[m];
        
        /* 
        Copy the sorted initial subarray from the first subarray num1 to
        a new array arr1, so that manipulation in the nums1 doesn't override
        the elements.
        /
        for(int i=0; i<m; i++) {
            arr1[i] = nums1[i];
        }
        
        // Put pointers on the start of the array arr1 and nums2.
        int i=0, j=0, k=0;
        
        while( i < m && j < n ) {
            
            // Compare elements at pointer, whichever is smaller will be added to 
            // the result nums1.
            if( arr1[i] < nums2[j] ) {
                nums1[k] = arr1[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        /*
        If the pointers are not been pointing to the last elements of the 
        subarrays, there must be remaining elements.
        Copy them over to the result array nums1.
        /
        while( i < m ) {
            nums1[k] = arr1[i];
            i++;
            k++;
        }
        
        while( j < n ) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
        
    }*/
}
