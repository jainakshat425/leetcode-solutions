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
    public List<Integer> preorderTraversal(TreeNode root) {        
        List<Integer> result = new ArrayList<Integer>();
        
        
        if( root == null ) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while( !stack.isEmpty() ) {
            
            TreeNode currNode = stack.pop();
            result.add( currNode.val );
            
            if( currNode.right != null ) {
                stack.push( currNode.right );
            }
            if( currNode.left != null ) {
                stack.push( currNode.left );
            }
        }
        
        // recursiveTraversal(result, root);
        return result;
    }
    
    private void recursiveTraversal(List<Integer> result, TreeNode node) {
        if( node == null ) return;
        
        result.add( node.val );
        recursiveTraversal(result, node.left);
        recursiveTraversal(result, node.right);
    }
}
