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
    public int maxDepth(TreeNode root) {
        /* 
                1
             2     3
            4 5      6
                       7
        */
        return bottomUp( root );
       // return topDown( root, 0 );
    }
    
    public int topDown(TreeNode root, int depth) {
        if( root == null ) return depth;
        
        return Math.max( topDown( root.left, depth+1 ), topDown( root.right, depth+1 ) );
    }
    
    public int bottomUp(TreeNode root) {
        if( root == null ) return 0;
        
        return Math.max( bottomUp(root.left), bottomUp(root.right) ) + 1;
    }
}
