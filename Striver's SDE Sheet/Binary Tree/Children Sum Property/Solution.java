public class Solution {
    public static void changeTree(BinaryTreeNode<Integer> root) {
        // Write your code here.
		if( root == null ) return;
		
		int childSum = calcChildSum(root);
		
		if( root.data < childSum ) {
			root.data = childSum;
		} else if( childSum < root.data ) {
			if( root.left != null ) 
				root.left.data = root.data;

			if( root.right != null ) 
				root.right.data = root.data;
		}
		changeTree( root.left );
		changeTree( root.right );
		
		childSum = calcChildSum(root);
		
		if( root.data < childSum ) {
			root.data = childSum;
		}
    }
	
	private static int calcChildSum(BinaryTreeNode<Integer> node) {
		int childSum = node.left != null ? node.left.data : 0;
		childSum += node.right != null ? node.right.data : 0;
		return childSum;
	}
}
