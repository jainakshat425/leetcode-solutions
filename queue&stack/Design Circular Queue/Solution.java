class MyCircularQueue {
    private int[] data;
    private int head, tail;
    
    // Initializes the object with the size of the queue to be k.
    public MyCircularQueue(int k) {
        data = new int[k];
        head = tail = -1;
    }
    
    // Inserts an element into the circular queue. Return true if the operation is successful.
    public boolean enQueue(int value) {
        if( isFull() ) {
            return false;
        }  
        
        if( isEmpty() ) {
            head = 0;
        } 
        tail = (tail+1) % data.length;

        data[tail] = value;
        
        return true;
    }
    
    // Deletes an element from the circular queue. Return true if the operation is successful.
    public boolean deQueue() {
        if( isEmpty() ) {
            return false;
        } 
        if( tail == head ) {
            tail = -1;
            head = -1;
        } else {
            head = (head+1) % data.length;
        } 
        return true;
    }
    
    // Gets the front item from the queue. If the queue is empty, return -1.
    public int Front() {
        if( isEmpty() ) {
            return -1;
        }
        return data[head];
    }
    
    // Gets the last item from the queue. If the queue is empty, return -1.
    public int Rear() {
        if( isEmpty() ) {
            return -1;
        }
        return data[tail];
    }
    
    public boolean isEmpty() {
        return head == -1;
    }
    
    // Checks whether the circular queue is full or not.
    public boolean isFull() {
        return (tail+1) % data.length == head;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
