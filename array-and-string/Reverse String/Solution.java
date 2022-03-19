class Solution {
    public void reverseString(char[] s) {
        /* 
        1. Use two pointers {left} and {right}.
        2. If character at {left} and {right} do not match, swap them.
        */
        
        // Use two pointers {left} and {right}.
        int left = 0, right = s.length - 1;
        
        while( left <= right ) {
            // If character at {left} and {right} do not match, swap them.
            if( s[left] != s[right] ) {
                swap( s, left, right );
            }
            left++;
            right--;
        }
    }
    
    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
