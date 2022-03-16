class Solution {
    public boolean validMountainArray(int[] arr) {
        /* 
        1. If array length is less than 3 or first element is greater than the next one, return false.
        2. Declare a boolean to store whether the array contains an index from where the numbers start descreasing.
        3. Iterate from the second number
            - If the number is equal to previous number, return false. (not a valid mountain)
            - If the peak is not found
                - Set peakFound to true if previous number was greater 
                - else the number are in the increasing order, and we'll continue peak search.
            - else the number should be in decreasing order, otherwise return false.
        */
        
        // If array length is less than 3 or first element is greater than the next one, return false.
        if( arr == null || arr.length < 3 || arr[0] > arr[1] ) {
            return false;
        }
        
        // Declare a boolean to store whether the array contains an index from where the numbers start descreasing.
        boolean peakFound = false;
        
        // Iterate from the second number
        for(int i=1; i<arr.length; i++) {
            
            // If the number is equal to previous number, return false. (not a valid mountain)
            if( arr[i-1] == arr[i] ) {
                return false;
            }
            
            // If the peak is not found
            if( !peakFound ) {
                // Set peakFound to true if previous number was greater 
                if( arr[i-1] > arr[i] ) {
                    peakFound = true;
                }
            } else if( arr[i-1] < arr[i] ) {
                // else the number should be in decreasing order, otherwise return false.
                return false;
            }
        }
        
        return peakFound;
    }
}
