class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        Deque<String> dq = new LinkedList();
        int dirStart = -1;

        for(int i=0; i<=n; i++) {
            char curChar = i != n ? path.charAt(i) : '\0';
            
            if( curChar == '/' || i == n ) {
                
                if( dirStart == -1 ) 
                    continue;
                
                String dir = path.substring(dirStart, i);

                if( dir.equals("..") ) {
                    if( !dq.isEmpty() )
                        dq.pollLast();
                } else if( !dir.equals(".") ) 
                    dq.offerLast(dir);

                dirStart = -1;
            } 
            else if( dirStart == -1 )
                dirStart = i;
        }
        
        StringBuilder canonical = new StringBuilder();
        
        while( !dq.isEmpty() ) {
            canonical.append('/');
            canonical.append(dq.pollFirst());
        }
        return canonical.length() == 0 ? "/" : canonical.toString();
    }
}
