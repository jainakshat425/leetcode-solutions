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
    public TreeNode deleteNode(TreeNode root, int key) {
        if( root == null )
            return null;
        if( root.val == key )
            return delete(root);
        
        if( key < root.val )
            root.left = deleteNode(root.left, key); 
        else
            root.right = deleteNode(root.right, key);
        
        return root;
    }
    
    private TreeNode delete(TreeNode node) {  
        // two child -> replace with inorder predecessor
        if( node.left != null && node.right != null ) {
            TreeNode pre = predecessor(node.left);
            
            node.val = pre.val;
            
            node.left = deleteNode(node.left, pre.val);
            
            return node;
        }
        // no child -> replace node to be deleted with null
        // one child -> replace node to be deleted with child
        return node.left != null ? node.left : node.right;
    }
    
    private TreeNode predecessor(TreeNode curr) {
        return curr.right == null ? curr : predecessor(curr.right);
    }
}
