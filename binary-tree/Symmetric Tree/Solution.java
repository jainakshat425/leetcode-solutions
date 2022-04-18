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
    public boolean isSymmetric(TreeNode root) {
        /* 
        1. Required - left root right (inorder) = right root left (reverse-inorder)
        2. Check if left and right subtree are symmetrical by passing root's left and right to {checkSymmetry} recursive method.
        3. If both left and right are null, current subtree is symmetrical
        4. If only one of them is null, then tree is not symmetrical
        5. If value of left node and right node does not match, then tree is not symmetrical
        6. Check if left's left subtree and right's right subtree is symmetrical and also left's right subtree and right's left subtree is symmetrical
        */ 
        
        // Check if left and right subtree are symmetrical by passing root's left and right to {checkSymmetry} recursive method.
        return checkSymmetry( root.left, root.right );
    }
    
    public boolean checkSymmetry(TreeNode left, TreeNode right) {
        // If both left and right are null, current subtree is symmetrical
        if( left == null && right == null ) return true;
      
        // If only one of them is null, then tree is not symmetrical
        if( left == null || right == null ) return false;
      
        // If value of left node and right node does not match, then tree is not symmetrical
        if( left.val != right.val ) return false;
        
        // Check if left's left subtree and right's right subtree is symmetrical and also left's right subtree and right's left subtree is symmetrical
        return checkSymmetry(left.left, right.right) && checkSymmetry(left.right, right.left);
    }
}
