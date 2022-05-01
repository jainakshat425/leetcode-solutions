class Solution {
    public boolean backspaceCompare(String s, String t) {
        // To keep the count of backspace encountered in string {s} and {t} respectively
        int backspace1 = 0;
        int backspace2 = 0;
        
        // Pointers to the current character of the string
        int p1 = s.length()-1;
        int p2 = t.length()-1;
        
        // Repeat while there is a character left in any of the string
        while( p1 >= 0 || p2 >= 0 ) {
            char sChar = '0', tChar = '0';
            
            // Get the character under pointers into a local variable
            if( p1 >= 0 ) {
                sChar = s.charAt( p1 );
            }
            if( p2 >= 0 ) {
                tChar = t.charAt( p2 );
            }
            
            /* Case 1: Current character is backspace
            Increase backspace count and move to the next character */
            if( sChar == '#' || tChar == '#' ) { 
                if( sChar == '#' ) {
                    backspace1++;
                    p1--;
                }
                if( tChar == '#' ) {
                    backspace2++;
                    p2--;
                }
            } 
            /* Case 2: Backspaces encountered previously
            Skip current character and decrement backspace count */
            else if( backspace1 > 0 || backspace2 > 0 ) {
                if( backspace1 > 0  ) {
                    p1--;
                    backspace1--;
                }
                if( backspace2 > 0 ) {
                    p2--;
                    backspace2--;
                }
            } 
            /* Case 3: Characters are not equal
            All the backspaces till current index are handled, but current
            characters are not matching, hence return false */
            else if( sChar != tChar ) {
                return false;
            }
            /* Case 4: Characters match
            All the backspaces till current index are handled, and current
            characters do match, move to the next characters */
            else {
                p1--;
                p2--;
            }
        }
        
        return true;
    }
}
