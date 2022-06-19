/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if( root == null )
            return subRoot == null;
        
        return isMatch(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isMatch(TreeNode root, TreeNode subRoot) {
        if( subRoot == null )
            return root == null;
        if( root == null )
            return false;
        if( root.val != subRoot.val )
            return false;
        return isMatch(root.left, subRoot.left) && isMatch(root.right, subRoot.right);
    }
}
