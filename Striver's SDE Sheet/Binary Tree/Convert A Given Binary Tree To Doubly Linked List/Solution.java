
/*************************************************************
 class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

*************************************************************/

import java.util.Stack;
public class Solution {
	
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
		if( root == null )
			return null;
		
		Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> curr = root;
		
		// Last left node is going to be head of linked list
		while( curr.left != null ) {
			stack.push(curr);
			curr = curr.left;
		}
		BinaryTreeNode<Integer> head = curr;
		
		while( curr != null  ) {
			// Pointer to the next node in the linked list of current node
			BinaryTreeNode<Integer> next = curr.right;
			
			if( next != null ) {
				// If there is a left node, next node will be from the left subtree
				while( next.left != null ) {
					stack.push( next );
					next = next.left;
				}
			} else if( !stack.isEmpty() ) {
				next = stack.pop();
			}
			// Link next pointer
			curr.right = next;
			// Link previous pointer
			if( next != null ) {
				next.left = curr;
			}
			// Move to the next node
			curr = curr.right;
		}
		
		return head;
	}
}
