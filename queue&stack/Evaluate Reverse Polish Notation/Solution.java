class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for(String token : tokens) {
            switch(token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                    int op1 = stack.pop();
                    stack.push(stack.pop() - op1);
                    break;
                case "/":
                    op1 = stack.pop();
                    stack.push(stack.pop() / op1);
                    break;
                default: 
                    stack.push(Integer.valueOf(token));                    
            }
        }
        
        return stack.pop();
    }
}
