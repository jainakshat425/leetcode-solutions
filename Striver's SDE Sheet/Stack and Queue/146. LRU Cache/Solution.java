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
        // If key doesn't exist, return -1
        if( !cache.containsKey( key ) ) {
            return -1;
        }
        
        DoublyLinkedList.Node node = cache.get( key );
        
        /* Make this node most recent node by deleting it from it's 
        original location in linkedlist and adding it back to head. */
        
        // Delete node
        linkedList.delete( node );
        // Make it head node (most recently used)
        node = linkedList.insertNewHead( node.key, node.value );
        // Update the pointer in the cache to the new node
        cache.put( key, node );
        
        // return node's value
        return node.value;
    }
    
    public void put(int key, int value) {
        /* If key exist in cache, delete the node corresponding to key
        and move it to head node (most recently used) */
        if( cache.containsKey( key ) ) {
            
            linkedList.delete( cache.get( key ) );
            
        } 
        // If cache is full, delete tail node (least recently used)
        else if( cache.size() == capacity ) {
            
            int lruKey = linkedList.deleteTail();
            cache.remove( lruKey );
        }
        
        // Create a new head node, as this is the most recently used key
        DoublyLinkedList.Node newNode = linkedList.insertNewHead( key, value );
        cache.put(key, newNode);
    }
}

class DoublyLinkedList {
       
    public Node head;
    public Node tail;
    
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
        
        // If head node is deleted, make the next node the new head node
        if( deleteNode == head ) {
            head = head.next;
        } 
        // If tail node is deleted, make the previous node the new tail node
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
        public int key, value;
        public Node next, prev;
        
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
