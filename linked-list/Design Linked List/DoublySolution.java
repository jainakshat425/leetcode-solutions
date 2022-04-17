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
        Node newNode = new Node(val, head, null);
        
        // existing head's previous should point to the new node
        if( head != null ) {
            head.prev = newNode;
        }
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

            // new node's previous should point to the existing last node
            newNode.prev = last;
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
        // Move {curr} to the node at index {index} 
        for(int i=0; i<index; i++) {
            curr = curr.next;
        }
        
        // New node's next will point to the current node at index {index}
        Node newNode = new Node(val, curr, curr.prev);
        
        // If {curr.prev} is null, new node will be inserted at head
        if( curr.prev == null ) {
            head = newNode;
        } else {
            // Else previous node will point to the new node
            curr.prev.next = newNode;
        }
        
        // current node's previous should point to the new node {newNode}
        curr.prev = newNode;
        
        size++;
    }
    
    // Delete the indexth node in the linked list, if the index is valid.
    public void deleteAtIndex(int index) {
        if( index >= size ) {
            return;
        }
        Node curr = head;
        
        // Move {curr} to the node at index {index}
        for(int i=0; i<index; i++) {            
            curr = curr.next;
        }
        
        // If {curr.prev} is null, delete head node by moving head to the next node.
        if( curr.prev == null ) {
            head = curr.next;
        } else {
            // Else prev node will point to the node after the index {index}
            curr.prev.next = curr.next;
            
            // and next node will point to the node before the index {index}
            if( curr.next != null ) {
                curr.next.prev = curr.prev;
            }
        }
        
        size--;
    }
    
    private class Node { 
        public int val;
        public Node next;
        public Node prev; 
        
        public Node(int val) {
            this.val = val;
        }
        
        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
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
