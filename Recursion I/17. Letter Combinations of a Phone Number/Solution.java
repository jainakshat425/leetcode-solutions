class Solution {
    
    private static final Map<Character,char[]> digitToLetters = new HashMap() {{
        put('2', new char[]{'a','b','c'});
        put('3', new char[]{'d','e','f'});
        put('4', new char[]{'g','h','i'});
        put('5', new char[]{'j','k','l'});
        put('6', new char[]{'m','n','o'});
        put('7', new char[]{'p','q','r','s'});
        put('8', new char[]{'t','u','v'});
        put('9', new char[]{'w','x','y','z'});
    }};
    
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        
        List<String> result = new ArrayList();
        
        if( n == 0 ) return result;
        
        letterCombinations(digits, n, 0, new StringBuilder(), result);
        
        return result;
    }
    
    public void letterCombinations(String digits, int n, int i, StringBuilder str, List<String> result) {
        
        if( i == n ) {
            result.add( str.toString() );
            return;
        }
        
        // Iterate for each letter corresponding to current digit 
        for(char letter : digitToLetters.get( digits.charAt(i) ))  {
            
            /* Append each letter, recurse for next digits, remove the current letter
            to generate the next combination through current digit */
            str.append( letter );
        
            letterCombinations(digits, n, i+1, str, result);
            
            str.deleteCharAt( str.length()-1 );
        }
    }
}
/*class Solution {
    
    private static final Map<Character,char[]> digitToLetters = new HashMap() {{
        put('2', new char[]{'a','b','c'});
        put('3', new char[]{'d','e','f'});
        put('4', new char[]{'g','h','i'});
        put('5', new char[]{'j','k','l'});
        put('6', new char[]{'m','n','o'});
        put('7', new char[]{'p','q','r','s'});
        put('8', new char[]{'t','u','v'});
        put('9', new char[]{'w','x','y','z'});
    }};
    
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        
        List<String> result = new ArrayList();
        
        if( n == 0 ) return result;
        
        Queue<String> queue = new LinkedList();
        queue.offer( "" );
                
        // Iterate for each digit
        for(int i=0; i<n; i++) {
            
            char digit = digits.charAt(i);
            int size = queue.size();
            
            // Iterate for each combination in queue
            for(int j=0; j<size; j++) {
                
                // Add each letter corresponding to current digit to the present combinations 
                String str = queue.poll();
                
                for(char letter : digitToLetters.get( digit ))  {
                    queue.offer( str + letter );
                }
            }
        }
        
        while( !queue.isEmpty() ) {
            result.add( queue.poll() );
        }
        
        return result;
    }
}*/
 
