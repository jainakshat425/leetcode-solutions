class Solution {
    public String reverseWords(String s) {
        
        /* 
        1. Convert string {s} to array of characters {characters}.
        2. Reverse each word in the reversed character array.
            - Declare {wStart} and {wEnd} - pointers to the start and end of a word, initialized to 0.
            - While {wStart} doesn't reaches end of the array
                - increment {wStart} while current character under {wStart} is a space.
                - once start index of word {wStart} is found, search for the end index {wEnd} of current word from the {wStart} index.
                - increment {wEnd} while current character under {wStart} is not a space.
                - reverse character array from {wStart} to {wEnd-1} (wEnd is pointing to the next character after word ends)
                - Assign {wEnd} to {wStart}, to start new word search from the end of the current word.
        3. return string from characters array.
        */
        
        // Convert string {s} to array of characters {characters}.
        char[] characters = s.toCharArray();
        
        // Reverse each word in the reversed character array.
        reverseWord( characters );
        
        // return string from characters array.
        return new String( characters );
    }
    
    private void reverseWord(char[] characters) {
        
        // Declare {wStart} and {wEnd} - pointers to the start and end of a word, initialized to 0.
        int wStart = 0, wEnd = 0;
        
        // While {wStart} doesn't reaches end of the array
        while( wStart < characters.length ) {
            
            // increment {wStart} while current character under {wStart} is a space.
            while( wStart < characters.length && characters[wStart] == ' ' ) {
                ++wStart;
            }
            
            // once start index of word {wStart} is found, search for the end index {wEnd} of current word from the {wStart} index.
            wEnd = wStart;
            
            // increment {wEnd} while current character under {wStart} is not a space.
            while( wEnd < characters.length && characters[wEnd] != ' ' ) {
                ++wEnd;
            }
            
            // reverse character array from {wStart} to {wEnd-1} (wEnd is pointing to the next character after word ends)
            reverse( characters, wStart, wEnd-1 );
            
            // Assign {wEnd} to {wStart}, to start new word search from the end of the current word.
            wStart = wEnd;
        }
    }
    
    private void reverse(char[] characters, int start, int end) {
        
        while( start < end ) {
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            
            ++start;
            --end;
        }
    }
}
