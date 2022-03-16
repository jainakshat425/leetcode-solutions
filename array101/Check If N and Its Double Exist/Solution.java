class Solution {
    public boolean checkIfExist(int[] arr) {
        /* 
        1. For each element arr[i] in the array
            - Iterate over the elements arr[j] after that.
            - Check if the element arr[i] is 2 times of arr[j] OR arr[j] is 2 times of arr[i]
        */
        
        // For each element arr[i] in the array
        for(int i=0; i<arr.length; i++) {
            
            // Iterate over the elements arr[j] after that.
            for(int j=i+1; j<arr.length; j++) {
                
                // Check if the element arr[i] is two times of arr[j] OR arr[j] is two times of arr[i]
                if( ((arr[j] * 2) == arr[i]) || ((arr[i] * 2) == arr[j]) ) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
