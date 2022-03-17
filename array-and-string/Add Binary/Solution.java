class Solution {
    public String addBinary(String a, String b) {
        /*
        Possibe Combinations - 
        a b c s r rc
        0 0 0 0 0 0
        0 0 1 1 1 0
        0 1 0 1 1 0
        0 1 1 2 0 1
        1 0 0 1 1 0
        1 0 1 2 0 1
        1 1 0 2 0 1
        1 1 1 3 1 1
        1. Declare
            - array {arrA} and {arrB} - Convert input {a} and {b} to character array.
            - pointers {i} and {j} - to point to the current element to process, 
                                    initialized to the last index of the array.
            - mutable string {result} - to store the sum of {a} and {b}
            - integer {carry} - Store carry resulting from 1 + 1, initialized to 0.
        2. Iterate while both {i} and {j} greater than 0
            - Calculate integer sum {intSum} of arrA[i], arrB[j], and {carry}.
            - switch on {intSum}
                - case 0, append 0 and carry = 0
                - case 1, append 1 and carry = 0
                - case 2, append 0 and carry = 1
                - case 4, append 1 and carry = 1
        3. Check if any of {i} or {j} is still greater than 0
            - Add the carry and elements and append them to {result}.
        5. If carry remains at the end, append it to the sum.
        4. Reverse the {result} and return it.
        */
        
        
        // to point to the current element to process, initialized to the last index of the array.
        int i = a.length() - 1, j = b.length() - 1;
        
        // to store the sum of {a} and {b}
        StringBuilder result = new StringBuilder();
        
        // Store carry resulting from 1 + 1, initialized to 0.
        int carry = 0;
        
        // Iterate while both {i} and {j} greater than 0
        while( i >= 0 && j >= 0 ) {
            
            // Calculate integer sum {sum} of arrA[i], arrB[j], and {carry}.
            carry = binarySum( result, a.charAt(i), b.charAt(j), carry );
            
            i--;
            j--;
        }
        
        // Check if any of {i} or {j} is still greater than 0
        while( i >= 0 ) {
            carry = binarySum( result, a.charAt(i), '0', carry );
            i--;
        }
        while( j >= 0 ) {
            carry = binarySum( result, '0', b.charAt(j), carry );
            j--;
        }
        
        // If carry remains at the end, append it to the sum.
        if( carry == 1 ) {
            result.append( 1 );
        }
        
        return result.reverse().toString();
    }
    
    private int binarySum(StringBuilder sum, char a, char b, int carry) {
        // Calculate integer sum {sum} of arrA[i], arrB[j], and {carry}.
        // a|b - '0' - returns the int value
        int intSum = ( a - '0' ) + ( b - '0' ) + carry;

        switch(intSum) {
            case 0: 
                sum.append( 0 );
                carry = 0;
                break;
            case 1: 
                sum.append( 1 );
                carry = 0;
                break;
            case 2: 
                sum.append( 0 );
                carry = 1;
                break;
            case 3: 
                sum.append( 1 );
                carry = 1;
                break;
        }
        return carry;
    }
}
