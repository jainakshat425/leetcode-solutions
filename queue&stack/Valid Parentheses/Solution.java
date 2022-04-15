class Solution {
    public boolean isValid(String s) {
        /* 
        1. Create stack to hold opening brackets.
        2. Loop over characters of string {s}
            - If current character {curr} is opening bracket, add it to {stack} 
            - Else current character is closing bracket, If stack is empty, return false.
            - Else stack contains opening brackets, match it with the current closing bracket. If not a valid match return false.
        3. If stack is empty, string is valid.
        */
        
        // Create stack to hold opening brackets.
        Stack<Character> stack = new Stack<Character>();
        
        // Loop over characters of string {s}
        for(int i=0; i<s.length(); i++) {
            
            char curr = s.charAt(i);
            
            // If current character {curr} is opening bracket, add it to {stack} 
            if( curr == '(' || curr == '{' || curr == '[' ) {
                stack.push(curr);
            } else if( stack.isEmpty() ) {
                // Else current character is closing bracket, If stack is empty, return false.
                return false;
            } else {
                // Else stack contains opening brackets, match it with the current closing bracket. If not a valid match return false.
                char last = stack.pop();
                
                if( 
                    (last == '(' && curr != ')') ||
                    (last == '{' && curr != '}') ||
                    (last == '[' && curr != ']') 
                ) {
                    return false;
                }
            }
        }
        
        // If stack is empty, string is valid.
        return stack.isEmpty();
    }
}
