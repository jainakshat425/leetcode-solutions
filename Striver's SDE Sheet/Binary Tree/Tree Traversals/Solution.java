public class Solution {
	public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
		// Write your code here.
		List<List<Integer>> ans = new ArrayList();
		// 0 index is Inorder, 1 is Pre-order and 2 is Post-order
		for(int i=0; i<3; i++) {
			ans.add( new ArrayList() );
		}
		getTreeTraversal(root, ans);

		return ans;
	}

	private static void getTreeTraversal(BinaryTreeNode<Integer> root, List<List<Integer>> ans) {
		if( root == null ) return;

		// Pre-order
		ans.get(1).add( root.data );

		getTreeTraversal(root.left, ans);

		// Inorder
		ans.get(0).add( root.data );

		getTreeTraversal(root.right, ans);

		// Post-order
		ans.get(2).add( root.data );
	}
}
