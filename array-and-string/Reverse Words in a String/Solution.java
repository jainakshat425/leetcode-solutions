class Solution {
    public String reverseWords(String s) {
        /* 
        1. Convert string {s} to array of characters {characters}.
        2. Reverse complete array by swaping characters from start and end.
        3. Reverse each word in the reversed character array.
            - Declare {wStart} and {wEnd} - pointers to the start and end of a word, initialized to 0.
            - While {wStart} doesn't reaches end of the array
                - increment {wStart} while current character under {wStart} is a space.
                - once start index of word {wStart} is found, search for the end index {wEnd} of current word from the {wStart} index.
                - increment {wEnd} while current character under {wStart} is not a space.
                - reverse character array from {wStart} to {wEnd-1} (wEnd is pointing to the next character after word ends)
                - Assign {wEnd} to {wStart}, to start new word search from the end of the current word.
        4. Clean spaces from the characters array
            - Two Pointers Approach
                - Slow/Write Pointer {j}
                - Fast/Read Pointer {i}
            - Declare 
                - integer j - pointer to the next index for write.
                - boolean word - Flag to check if a word is found.
            - Loop over the characters of array 
                - if current character {characters[i]} is not a space
                    - put it into the array {characters[j]} and increment write counter.
                    - set the {word} flag to true.
                - else if the word flag is true (found a word before this space)
                    - we can accomodate this space, put space into the array and increment write counter.
                    - set the {word} flag to false (if there is a space again, it should not be added)
            - If the last character {character[j-1]} is a space, decrement {j}.
            - Return a string from 0th index of the array having {j-1} characters.
        */
        
        // Convert string {s} to array of characters {characters}.
        char[] characters = s.toCharArray();
        
        // Reverse complete array by swaping characters from start and end.
        reverse(characters, 0, characters.length-1);
        
        // Reverse each word in the reversed character array.
        reverseWords( characters );
        
        // Clean spaces from the characters array
        return cleanSpaces(characters);
    }
    
    private void reverse(char[] characters, int start, int end) {
        while(start < end) {
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            
            start++;
            end--;
        }
    }
    
    private void reverseWords(char[] characters) {
        
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
            reverse(characters, wStart, wEnd-1);
            
            // Assign {wEnd} to {wStart}, to start new word search from the end of the current word.
            wStart = wEnd;
        }
    }
    
    private String cleanSpaces(char[] characters) {
        // pointer to the next index to write.
        int j = 0;
        // Flag to check if a word is found.
        boolean word = false;
        
        // Loop over the characters of array 
        for(int i=0; i<characters.length; i++) {
            
            // if current character {characters[i]} is not a space
            if( characters[i] != ' ' ) {
                
                // put it into the array {characters[j]} and increment write counter.
                characters[j++] = characters[i];
                word = true;
            } 
            // else if the word flag is true (found a word before this space)
            else if( word ) {
                
                // we can accomodate this space, put space into the array and increment write counter.
                characters[j++] = ' ';
                
                // set the {word} flag to false (if there is a space again, it should not be added)
                word = false;
            }
        }
        
        // If the last character {character[j-1]} is a space, decrement {j}.
        if( characters[j-1] == ' ' ) {
            j--;
        }
        
        // Return a string from 0th index of the array having {j-1} characters.
        return String.copyValueOf( characters, 0, j );
    }    
}
