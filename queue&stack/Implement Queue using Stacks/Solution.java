class MyQueue {

    private Stack<Integer> stack;
    private int front;
    
    public MyQueue() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if( stack.isEmpty() ) {
            front = x;
        }
        stack.push( x );
    }
    
    public int pop() {
        Stack<Integer> tempStack = new Stack<Integer>();
        
        while(!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        
        int result = tempStack.pop();
        
        front = tempStack.peek();
        
        while(!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return result;
    }
    
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
