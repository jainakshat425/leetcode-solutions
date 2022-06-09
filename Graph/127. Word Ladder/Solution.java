class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if( !wordList.contains(endWord) ) 
            return 0;
        
        Set<String> visited = new HashSet();
        Queue<Pair> queue = new LinkedList();
        queue.offer(new Pair(beginWord, 1));
        
        while( !queue.isEmpty() ) {
            String word = queue.peek().word;
            int dist = queue.peek().distance;
            queue.poll();
            
            for(String adjWord : wordList) {
                
                if( visited.contains(adjWord) )
                    continue;
                
                if( isAdjacent( word, adjWord ) ) {
                    
                    if( adjWord.equals(endWord) )
                        return dist+1;
                    
                    visited.add(adjWord);
                    
                    queue.offer(new Pair(adjWord, dist+1));
                }
            }
        }
        return 0;
    }
    
    private boolean isAdjacent(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        
        for(int i=0; i<n; i++) {
            if( s1.charAt(i) != s2.charAt(i) ) {
                count++;
                
                if( count > 1 )
                    return false;
            }
        }
        return true;
    }
    
    class Pair {
        public String word;
        public int distance;
        
        public Pair(String w, int d) {
            word = w;
            distance = d;
        }
    }
}
/* 
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if( !wordList.contains(endWord) ) 
            return 0;
        
        Queue<Pair> queue = new LinkedList();
        queue.offer(new Pair(beginWord, 1));
        
        while( !queue.isEmpty() ) {
            String word = queue.peek().word;
            int dist = queue.peek().distance;
            queue.poll();
            
            ListIterator<String> itr = wordList.listIterator();
            
            while( itr.hasNext() ) {
                String adjWord = itr.next();
                
                if( isAdjacent( word, adjWord ) ) {
                    
                    if( adjWord.equals(endWord) )
                        return dist+1;
                    
                    itr.remove();
                    
                    queue.offer(new Pair(adjWord, dist+1));
                }
            }
        }
        return 0;
    }
    
    private boolean isAdjacent(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        
        for(int i=0; i<n; i++) {
            if( s1.charAt(i) != s2.charAt(i) ) {
                count++;
                
                if( count > 1 )
                    return false;
            }
        }
        return true;
    }
    
    class Pair {
        public String word;
        public int distance;
        
        public Pair(String w, int d) {
            word = w;
            distance = d;
        }
    }
}

*/
