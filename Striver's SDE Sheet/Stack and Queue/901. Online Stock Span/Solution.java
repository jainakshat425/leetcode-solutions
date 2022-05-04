class StockSpanner {
    private Stack<int[]> stack;
    
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
          
        /* Remove all the smaller numbers from the stack and add there span
        as smaller number will not be able block any next number */
        while( !stack.isEmpty() && stack.peek()[0] <= price ) {
            span += stack.pop()[1];
        }    
        
        // Push the current price and it's span into stack
        stack.push(new int[]{price, span});
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
