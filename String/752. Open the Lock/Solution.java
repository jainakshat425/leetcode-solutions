class Solution {
    public int openLock(String[] deadends, String target) {
        int turns = 0;
        Set<String> visited = new HashSet();
        Queue<String> queue = new LinkedList();
        
        for(String dead : deadends) 
            visited.add( dead );
        
        if( visited.contains("0000") )
            return -1;
        
        queue.offer("0000");
        visited.add("0000");
        
        while( !queue.isEmpty() ) {
            int size = queue.size();
            
            while( size-- > 0 ) {
                String str = queue.poll();
                
                if( str.equals(target) ) 
                    return turns;
                
                char[] digits = str.toCharArray();
                
                for(int i=0; i<4; i++) {
                    char digit = digits[i];
                    
                    // next num
                    digits[i] = getNext(digit);
                    
                    String nextNum = new String(digits);
                    if( visited.add(nextNum) )
                        queue.offer(nextNum);
                    
                    // prev num
                    digits[i] = getPrev(digit);
                    
                    String prevNum = new String(digits);
                    if( visited.add(prevNum) )
                        queue.offer(prevNum);
                    
                    digits[i] = digit;
                }
            }
            turns++;
        }
        return -1;
    }
    
    private char getNext(char c) {
        return c == '9' ? '0' : (char)(c+1);
    }
    
    private char getPrev(char c) {
        return c == '0' ? '9' : (char)(c-1);
    }
}
