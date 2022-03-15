class Solution {
    public void duplicateZeros(int[] arr) {
        /* 
        1. Use two pointers approach, keep one pointer on the input array and one pointer on output array.
        2. Iterate over the array, and keep copying the element to a new temp array.
        3. If the copied element is 0, copy 0 to the next index as well.
        4. Output pointer can go beyond array bounds, so add check for array bounds.
        */
        
        // Use two pointers approach, keep one pointer on the input array (i)
        // and one pointer on output array (j).
        int[] tempArr = new int[arr.length];
        int j = 0;
        
        // Iterate over the array, and keep copying the element to a new temp array.
        for(int i=0; i<arr.length && j<arr.length; i++) {
            tempArr[j] = arr[i];
            j++;
            
            // If the copied element is 0, copy 0 to the next index as well.
            if( arr[i] == 0 && j<arr.length ) {
                tempArr[j] = 0;
                j++;
            }
        }
      
        // Copy elements to the original array.
        for(int i=0; i<arr.length; i++) {
            arr[i] = tempArr[i];
        }
    }
}
