public class Solution {
    public int[] prevSmaller(int[] A) {
        int n = A.length;
        int[] ans = new int[n];

        // Stack to hold previous number
        Stack<Integer> stack = new Stack<>();

        // Iterate from 0 - n-1
        for(int i=0; i<n; i++) {

            /* Remove the numbers from the stack until the number on 
            the top of the stack is smaller than current number or
            stack becomes empty */
            while( !stack.isEmpty() && A[i] <= stack.peek() ) {
                stack.pop();
            }

            /* If stack is empty, then there is no number previous to 
            current number which is smaller */
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            
            stack.push( A[i] );
        }
        return ans;
    }
}
