class MinStack {
    private List<Node> data;
    
    // initializes the stack object.
    public MinStack() {
        data = new ArrayList<Node>();
    }
    
    // pushes the element val onto the stack.
    public void push(int val) {
        
        int min = val;
        
        if( !data.isEmpty() ) {
            min = Math.min(getMin(), min);
        }
        
        data.add(new Node(val, min));
    }
    
    // removes the element on the top of the stack.
    public void pop() {
        data.remove(data.size()-1);
    }
    
    // gets the top element of the stack.
    public int top() {
        return topNode().value;
    }
    
    // retrieves the minimum element in the stack.
    public int getMin() {
        return topNode().min;
    }
    
    private Node topNode() {
        return data.get(data.size()-1);
    }
    
    private class Node {
        public int value;
        public int min;
        
        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
