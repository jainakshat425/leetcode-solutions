public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {

        int n = A.length;

        // Calculate the XOR of 1 to n 
        int xor = xorTillN( n );

        // XOR the numbers from array A with the XOR of 1 to n {xor}
        // After this {xor} will contain the xor of missing number and 
        // repeating number as other will cancel out
        for(int num : A) {
            xor ^= num;
        }

        // Find the index of right most bit in the {xor} which is set
        int index = getRightmostSetBitIndex( xor );

        // Used to check if the bit at {index} is set or not in a number
        int mask = 1 << index;

        // num1 will be the xor of all the numbers where {index} bit is set
        int num1 = 0;
        // num1 will be the xor of all the numbers where {index} bit is not set
        int num2 = 0;

        for(int i=0; i<n; i++) {
            /* 
            XOR the numbers from array A with num1 or num2
            according to the rightmost bit of the number {A[i]}
            is set or not.
            */

            // If bit is not set, xor it with num1
            if( (A[i] & mask) == 0 ) {
                num1 ^= A[i];
            } else {
                // If bit is set, xor it with num2
                num2 ^= A[i];
            }

            /* 
            Simultaneously XOR the numbers from 1 to n
            according to the rightmost bit of the number {i+1}
            is set or not.
            */

            int num = i+1;

            // If bit is not set, xor it with num1
            if( (num & mask) == 0 ) {
                num1 ^= num;
            } else {
                // If bit is set, xor it with num2
                num2 ^= num;
            }
        }

        /*
        num1 and num2 are the missing and repeating number
        if num1 exist in the array, then num1 is repeating number
        and num2 is missing number and vice versa.
        */
        int[] result = new int[2];
        if( isNumberExist(A, num1) ) {
            result[0] = num1; // repeating number
            result[1] = num2; // missing number
        } else {
            result[0] = num2; // repeating number
            result[1] = num1; // missing number
        }
        return result;
    }

    private int getRightmostSetBitIndex(int num) {
        int index = -1;
        /*
        Loops condition breaks only when num is 0
        Otherwise we'll have atleast bit in the number
        which is set and at some point doing a bitwise
        AND will result in non-zero value.
        */
        while( num != 0 ) {
            
            index++;

            if( (num & 1) != 0 ) {
                break;
            }

            num = num >> 1;
        }
        return index;
    }

    private boolean isNumberExist(int[] arr, int val) {
        for(int num : arr) {  
            if( num == val ) {
                return true;
            }
        }
        return false;
    }

    private int xorTillN(int n) {
        int remainder = n%4;

        switch( remainder ) {
            case 1: 
                return 1;
            case 2: 
                return n+1;
            case 3: 
                return 0;
            default: // when 0
                return n;
        }
    }
}
