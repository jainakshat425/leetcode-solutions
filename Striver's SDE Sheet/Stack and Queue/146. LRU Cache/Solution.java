class LRUCache {

    private int capacity;
    private Map<Integer,DoublyLinkedList.Node> cache;
    private DoublyLinkedList linkedList;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.linkedList = new DoublyLinkedList();
    }
    
    public int get(int key) {
        
        if( !cache.containsKey( key ) ) {
            return -1;
        }
        
        DoublyLinkedList.Node node = cache.get( key );
        
        linkedList.delete( node );
        node = linkedList.insertNewHead( node.key, node.value );
        
        cache.put( key, node );
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if( cache.containsKey( key ) ) {
            
            linkedList.delete( cache.get( key ) );
            
        } else if( cache.size() == capacity ) {
            
            int lruKey = linkedList.deleteTail();
            cache.remove( lruKey );
        }
        
        DoublyLinkedList.Node newNode = linkedList.insertNewHead( key, value );
        cache.put(key, newNode);
    }
}

class DoublyLinkedList {
       
    public Node head;
    public Node tail;
    
    public void insert(int key, int value) {
        
        Node newNode = new Node(key, value);
        
        if( head == null ) {
            head = newNode;
            tail = newNode;
            return;
        }
        
        // Connect new node to tail node
        tail.next = newNode;
        newNode.prev = tail;
        
        // Make new node as the new tail node
        tail = newNode;
    }
    
    public int delete(Node deleteNode) {
        Node nextNode = deleteNode.next;
        Node prevNode = deleteNode.prev;
        
        if( nextNode != null ) {
            // Disconnect from next node
            nextNode.prev = prevNode;
        }
        if( prevNode != null ) {
            // Disconnect from previous of {deleteNode} 
            prevNode.next = nextNode;
        }
        
        if( deleteNode == head ) {
            head = head.next;
        } 
        if( deleteNode == tail ) {
            tail = tail.prev;
        }
        
        return deleteNode.key;
    }
    
    public int deleteTail() {
        
        if( tail == null ) return -1;
        
        return delete( tail );
    }
    
    public Node insertNewHead(int key, int value) {
        Node newNode = new Node(key, value);
        
        if( tail == null ) {
            tail = newNode;
        } else {
            // Connect to head
            newNode.next = head;
            head.prev = newNode;
        }
        // Mark the new node as the new head node
        head = newNode;
        
        return newNode;
    }
    
    public class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
