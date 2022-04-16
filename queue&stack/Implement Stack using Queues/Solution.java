class MyStack {
    private Queue<Integer> queue;
    private int top;
    
    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        top = x;
        queue.offer( x );
    }
    
    public int pop() {
        int size = queue.size();
        
        for(int i=0; i<size-1; i++) {
            int num = queue.poll();
            queue.offer( num );
            
            if( i == size-2 ) {
                top = num;
            }
        }
        
        return queue.poll();
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
