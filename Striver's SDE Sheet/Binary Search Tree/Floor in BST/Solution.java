public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        TreeNode<Integer> curr = root;
		int floor = 0;
		
		while( curr != null ) {
			if( curr.data <= X ) {
				floor = curr.data;
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		return floor;
    }
}
