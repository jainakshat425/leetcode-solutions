class Solution {
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
        */
        
        int[] arr1 = new int[m];
        
        /* 
        Copy the sorted initial subarray from the first subarray num1 to
        a new array arr1, so that manipulation in the nums1 doesn't override
        the elements.
        */
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
        */
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
        
    }
}
