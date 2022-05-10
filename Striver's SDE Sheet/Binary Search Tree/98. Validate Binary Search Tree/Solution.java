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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long low, long high) {
        if( root == null )
            return true;
        
        // If current node's value exceeds the bound, the tree is not BST
        if( root.val <= low || root.val >= high )
            return false;
        
        // Check if left subtree is a valid BST
        boolean leftValid = isValidBST(root.left, low, root.val);
        
        if( !leftValid )
            return false;
        
        // Check if right subtree is a valid BST
        return isValidBST(root.right, root.val, high);
    }
}
