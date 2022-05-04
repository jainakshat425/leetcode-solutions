class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        int max = Integer.MIN_VALUE;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<=n; i++) {
            
            /* If there is no right smaller (i==n) or current height (heights[i]) is the 
            right smaller of the height present at the top of the stack {heights[stack.peek()]}, 
            then area can be calculated for the top of the stack */
            while( !stack.isEmpty() && ( i == n || heights[stack.peek()] > heights[i] ) ) {
                
                // Remove the stack top and store it in height
                int height = heights[stack.pop()];
                
                /* If i==n, then there is no right smaller, else current height is the right 
                smaller */
                int rightSmall = (i == n) ? n : i;
                
                /* If stack is empty, then there is no left smaller, else top of the stack
                is the left smaller */
                int leftSmall = stack.isEmpty() ? -1 : stack.peek();
                
                int width = rightSmall - leftSmall - 1;
                
                max = Math.max( max, height*width );
            }
            // Current height can be the left smaller for the next heights */
            stack.push(i);
        }
        
        return max;
    }
}
/*
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int lastIndex = n-1;
        
        int max = Integer.MIN_VALUE;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        // For each index, we store the index of nearest smaller number in the left
        int[] leftSmall = new int[n];
        
        for(int i=0; i<n; i++) {
            
            // While the stack is not empty and numbers in the stack are greater 
            while( !stack.isEmpty() && heights[stack.peek()] >= heights[i] ) {
                // Remove them, as we need smaller number's index.
                stack.pop();
            }
            
            // If the stack is empty, all the elements in the left are greater
            leftSmall[i] = stack.isEmpty() ? 0 : stack.peek()+1;
            
            // Current number is the smallest of all in the stack, hence push it
            stack.push( i );
        }
        
        stack.clear();
                
        for(int i=lastIndex; i>=0; i--) {
            
            while( !stack.isEmpty() && heights[stack.peek()] >= heights[i] ) {
                stack.pop();
            }
            
            int rightSmall = stack.isEmpty() ? lastIndex : stack.peek()-1;
            
            stack.push( i );
            
            int width = rightSmall - leftSmall[i] + 1;
                        
            max = Math.max( max, width * heights[i] );
        }
        
        return max;
    }
}*/
