class LFUCache {

    private final int capacity;
    private Map<Integer,DLLNode> cache;
    private int minFreq;
    private Map<Integer,DoublyLinkedList> freqMap;
        
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.minFreq = 0;
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        DLLNode node = cache.get( key );
        
        if( node == null ) {
            return -1;
        }
        // Update frequency
        updateNode( node );
        return node.value;
    }
    
    public void put(int key, int value) {
        // corner case: if capacity is 0, return
        if( capacity == 0 ) return;
                
        // if current key already exist, update the value and frequency
        if( cache.containsKey( key ) ) {
            
            // Update value
            DLLNode node = cache.get( key );
            node.value = value;
            
            // Update frequency
            updateNode(node);
        } else {
            // cache is full? delete the LFU item
            if( cache.size() == capacity ) {
                // LFU used list
                DoublyLinkedList minFreqDLL = freqMap.get( minFreq );

                // Delete LRU node 
                DLLNode deleteNode = minFreqDLL.removeLastNode();

                /* If frequency of removed node is the minimum frequency and there are
                 no more nodes with this frequency, increase minimum frequency
                 and remove the list */
                if( minFreq == deleteNode.freq  && minFreqDLL.size == 0 ) {
                    minFreq++;
                    freqMap.remove( deleteNode.freq );
                }

                // Remove the key from cache as well
                cache.remove( deleteNode.key );
            }

            // create new node, and put it in cache
            DLLNode newNode = new DLLNode(key, value);
            cache.put( key, newNode );

            // new min freq is 1
            minFreq = 1;

            // Add to the 1's frequency list
            addToFreqList(newNode);
        }
    }
    
    private void updateNode(DLLNode node) {
        // Get list corresponding to node's frequency
        DoublyLinkedList currDoublyLL = freqMap.get( node.freq );
        
        // Remove node from the current frequency list
        currDoublyLL.removeNode( node );

         /* If current frequency is the minimum frequency and there are
         no more nodes with this frequency, increase minimum frequency
         and remove the list */
        if( minFreq == node.freq  && currDoublyLL.size == 0 ) {
            minFreq++;
            freqMap.remove( node.freq );
        }

        // Increase nodes frequency
        node.freq++;

        // Add to the updated frequency list
        addToFreqList(node);
    }
    
    private void addToFreqList(DLLNode node)  {
        // Get list corresponding to current node's frequency
        DoublyLinkedList freqDoublyLL = freqMap.get( node.freq );
        
        if( freqDoublyLL == null ) {
            freqDoublyLL = new DoublyLinkedList();
            freqMap.put( node.freq, freqDoublyLL );
        }
        freqDoublyLL.addNode( node );
    }
}

class DLLNode {
    public DLLNode prev, next;
    public int key, value;
    public int freq;

    public DLLNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoublyLinkedList {
    private DLLNode head, tail;
    public int size;
    
    public DoublyLinkedList() {
        size = 0;
        
        // create dummy haid and tail 
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        
        // connect head and tail 
        head.next = tail;
        tail.prev = head;
    }
    
    public DLLNode addNode(DLLNode newNode) {        
        DLLNode nextNode = head.next;
        
        // connect new node and head node
        head.next = newNode;
        newNode.prev = head;
        
        // connect new node and next node
        newNode.next = nextNode;
        nextNode.prev = newNode;
        
        size++;
        
        return newNode;
    }
    
    public DLLNode removeNode(DLLNode deleteNode) {
        DLLNode nextNode = deleteNode.next;
        DLLNode prevNode = deleteNode.prev;
        
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
        
        size--;
        
        return deleteNode;
    }
    
    public DLLNode removeLastNode() {
        return removeNode( tail.prev );
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
