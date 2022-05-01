class Trie {

    private Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        int n = word.length();
        Node curr = root;
        
        for(int i=0; i<n; i++) {
            
            int index = word.charAt(i) - 'a';
            
            if( curr.descendants[index] == null ) {
                curr.descendants[index] = new Node();
            } 
            curr = curr.descendants[index];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        Node wordNode = find( word );
        return wordNode != null && wordNode.isWord;
    }
    
    public boolean startsWith(String prefix) {
        return find( prefix ) != null;
    }
    
    private Node find(String key) {
        int n = key.length();
        Node curr = root;
        
        for(int i=0; i<n; i++) {
            
            int index = key.charAt(i) - 'a';
            
            if( curr.descendants[index] == null ) {
                return null;
            } 
            
            curr = curr.descendants[index];
        }
        return curr;
    }
    
    public class Node {
        public static final int N = 26;
        public Node[] descendants;
        public boolean isWord;
        
        public Node() {
            descendants = new Node[N];
        }
    }
}
/*
class Trie {

    private Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        int n = word.length();
        Node curr = root;
        
        for(int i=0; i<n; i++) {
            
            Node next;
            char letter = word.charAt(i);
            
            if( !curr.descendants.containsKey( letter ) ) {
                next = new Node();
                curr.descendants.put(letter, next);
            } else {
                next = curr.descendants.get( letter );
            }
            curr = next;
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        Node wordNode = find( word );
        return wordNode != null && wordNode.isWord;
    }
    
    public boolean startsWith(String prefix) {
        return find( prefix ) != null;
    }
    
    private Node find(String key) {
        int n = key.length();
        Node curr = root;
        
        for(int i=0; i<n; i++) {
            
            int index = key.charAt(i) - 'a';
            
            if( !curr.descendants.containsKey( letter ) ) {
                return null;
            } 
            
            curr = curr.descendants.get( letter );
        }
        return curr;
    }
    
    public class Node {
        Map<Character,Node> descendants;
        boolean isWord;
        
        public Node() {
            descendants = new HashMap<>();
            isWord = false;
        }
    }
}
*/
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
