class MyLinkedList {
    
    private Node head;
    private int size;
    
    // Initializes the MyLinkedList object.
    public MyLinkedList() {
        size = 0;
    }
    
    // Get the value of the indexth node in the linked list. If the index is invalid, return -1.
    public int get(int index) {
        if( index >= size ) {
            return -1;
        }
        
        Node curr = head;
        
        // Move pointer {curr} to required index {index}
        for(int i=0; i<index; i++) {            
            curr = curr.next;
        }
        
        return curr.val;
    }
    
    // Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
    public void addAtHead(int val) {
        // Create new node pointing to head
        Node newNode = new Node(val, head);
        // Point head to the new node
        head = newNode;
        
        size++;
    }
    
    // Append a node of value val as the last element of the linked list.
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        
        // If head is null, insert the new node at head
        if( head == null ) {
            head = newNode;
        } else {
            Node last = head;
        
            // Move pointer to the last node
            while( last.next != null ) {
                last = last.next;
            }

            // Make new node the next node of the last node
            last.next = newNode;
        }

        size++;
    }
    
    // Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
    public void addAtIndex(int index, int val) {
        if( index > size ) {
            return;
        } 
        // Add new node after the last node
        if( index == size ) {
            addAtTail(val);
            return;
        }
        
        Node curr = head;
        Node prev = null;
        // Move {curr} to the node at index {index} and {prev} to node before it
        for(int i=0; i<index; i++) {
            prev = curr;
            curr = curr.next;
        }
        
        // New node will point to the current node at index {index}
        Node newNode = new Node(val, curr);
        
        // If {prev} is null, new node will be inserted at head
        if( prev == null ) {
            head = newNode;
        } else {
            // Else previous node will point to the new node
            prev.next = newNode;
        }
        
        size++;
    }
    
    // Delete the indexth node in the linked list, if the index is valid.
    public void deleteAtIndex(int index) {
        if( index >= size ) {
            return;
        }
        Node curr = head;
        Node prev = null;
        
        // Move {curr} to the node at index {index} and {prev} to node before it
        for(int i=0; i<index; i++) {            
            prev = curr;
            curr = curr.next;
        }
        
        // If {prev} is null, delete head node by moving head to the next node.
        if( prev == null ) {
            head = curr.next;
        } else {
            // Else prev node will point to the node after index {index}
            prev.next = curr.next;
            // Deleted node will not point to the next node anymore
            curr.next = null;
        }
        
        size--;
    }
    
    private class Node { 
        public int val;
        public Node next;
        
        public Node(int val) {
            this.val = val;
        }
        
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
