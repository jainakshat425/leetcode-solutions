class Solution {
    public int findNumbers(int[] nums) {
        /* 
        1. Declare integer count to store the count of numbers containing an even number of digits
        2. Iterate over nums.
        3. Check if it's even digit number.
            3a. Create integer numOfDigits to store number of digits in the number.
            3b. While the number is greater than 0. 
                3b1. Divide it by 10 - removing Least Significant Digit one by one.
                3b2. Increment numOfDigits.
            3c. Calculate modulus(reminder) of numOfDigits by 2.
            3d. If modulus is 0, number of digits is even.
        4. If even, increase the count.
        */
        
        // Declare integer count to store the count of numbers containing an even number of digits
        int count = 0;
        
        // Iterate over nums.
        for(int num : nums) {
            // Check if it's even digit number.
            if( isEvenDigitNumber( num ) ) {
                // If even, increase the count.
                count++;
            }
        }
        return count;
    }
    
    private boolean isEvenDigitNumber(int num) {
        // Create integer numOfDigits to store number of digits in the number.
        int numOfDigits = 0;

        // While the number is greater than 0. 
        while( num > 0 ) {
            // Divide it by 10 - removing Least Significant Digit one by one.
            num /= 10;
            
            // Increment numOfDigits.
            numOfDigits++;
        }
        
        // Calculate modulus(reminder) of numOfDigits by 2.
        // If modulus is 0, number of digits is even.
        return numOfDigits % 2 == 0;
    }
}
