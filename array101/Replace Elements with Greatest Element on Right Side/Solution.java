class Solution {
    public int[] replaceElements(int[] arr) {
        /* 
        1. Iterate from right to left
            - Check if current element arr[i] is greater than max
                - Backup arr[i] in a temp variable
                - Assign current max to the index arr[i].
                - Update max to the new max arr[i].
            - else, assign current max to the index arr[i] 
        */
        
        int max = -1, temp;
        
        // Iterate from right to left
        for(int i=arr.length-1; i>=0; i--) {
            
            // Check if current element arr[i] is greater than max
            if( arr[i] > max ) {
                
                // Backup arr[i] in a temp variable
                temp = arr[i];
                // Assign current max to the index arr[i].
                arr[i] = max;
                // Update max to the new max arr[i].
                max = temp;
                
            } else {
                // else, assign current max to the index arr[i] 
                arr[i] = max;
            }
        }
        
        return arr;
    }
}
