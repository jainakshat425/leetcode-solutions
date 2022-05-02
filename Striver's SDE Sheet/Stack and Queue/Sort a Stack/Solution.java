import java.util.Stack;

public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		if( stack.isEmpty() ) {
			return;
		}
		// Keep the current top of the stack in the function stack
		int top = stack.pop();
		
		// Call sort stack for remaining stack, until it becomes empty
		sortStack( stack );
		
		// Once the stack will become empty, start inserting the numbers 
		insertDescOrder(stack, top);
	}
	
	private static void insertDescOrder(Stack<Integer> stack, int num) {
		/* Push current element into stack if stack is empty or the last
		number in the stack is larger than/equal to current number */
		if( stack.isEmpty() || stack.peek() <= num ) {
			stack.push( num );
			return;
		}
		
		/* Current top the stack is larger than current number, hence remove it 
		from stack and keep it in the function stack */
		int top = stack.pop();
		
		// Try to insert this number now
		insertDescOrder(stack, num);
		
		// Once the {num} is inserted, place the {top} back at the top
		stack.push( top );
	}

}
