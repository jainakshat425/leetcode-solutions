import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> traverseBoundary(TreeNode root){

		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add( root.data );
		
		if( isLeafNode(root) ) return ans;
		
		// Add the left boundary of the tree, excluding root and leaf node
		addLeftBoundary(root.left, ans);
		// Add all the leaf nodes from left to right
		addLeafNodes(root, ans);
		// Add the reversed right boundary excluding root and leaf node
		addRightBoundary(root.right, ans);
		
		return ans;
	}
	
	private static boolean isLeafNode(TreeNode node) {
		return (node.left == null && node.right == null);
	}
	
	private static void addLeftBoundary(TreeNode root, ArrayList<Integer> ans) {
		if( root == null || isLeafNode(root) ) 
			return;
		
		ans.add( root.data );
		
		// If left node exist, no need to check for right node
		if( root.left != null ) 
			addLeftBoundary(root.left, ans);
		else 
			addLeftBoundary(root.right, ans);
	}
	
	private static void addLeafNodes(TreeNode root, ArrayList<Integer> ans) {
		if( root == null )
			return;
		
		// If current node is a leaf node, add it and return
		if( isLeafNode(root) ) {
			ans.add( root.data );
			return;
		}
		
		// Else add leaf nodes from left subtree
		addLeafNodes(root.left, ans);
		// Add leaf nodes from right subtree
		addLeafNodes(root.right, ans);
	}
	
	private static void addRightBoundary(TreeNode root, ArrayList<Integer> ans) {
		if( root == null || isLeafNode(root) ) 
			return;
		
		// If right node exist, no need to check for left node
		if( root.right != null ) 
			addRightBoundary(root.right, ans);
		else 
			addRightBoundary(root.left, ans);
		
		ans.add( root.data );
	}
	
}
