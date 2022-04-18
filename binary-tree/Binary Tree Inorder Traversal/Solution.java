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
    public List<Integer> inorderTraversal(TreeNode root) {
        /* 
        1. Create a pointer to the root node {curr} and a {stack} to hold nodes.
        2. Repeat while {curr} != null OR {stack} is not empty 
            - Repeat while {curr} != null to reach the leftmost node
                - Add {curr} node to stack
                - Move {curr} to left node  
            - Pop the top of the {stack} and add it to the {result}.
            - Move the {curr} pointer to the right node as left is processed.
        */
        
        List<Integer> result = new ArrayList<Integer>();
        
        if( root == null ) return result;
        
        // Create a pointer to the root node {curr} and a {stack} to hold nodes.
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        
        // Repeat while {curr} != null OR {stack} is not empty 
        while( curr != null || !stack.isEmpty() ) {
            
            // Repeat while {curr} != null to reach the leftmost node
            while( curr != null  ) {
                
                // Add {curr} node to stack
                stack.push( curr );
                // Move {curr} to left node  
                curr = curr.left;
            } 
            
            // Pop the top of the {stack} and add it to the {result}.
            curr = stack.pop();
                
            result.add( curr.val );

            // Move the {curr} pointer to the right node as left is processed.
            curr = curr.right;
        }
        
        // recursiveInorder( result, root );
        return result;
    }
    
    public void recursiveInorder(List<Integer> result, TreeNode node) {
        if( node == null ) return;
        
        recursiveInorder(result, node.left);
        result.add( node.val );
        recursiveInorder(result, node.right);
    }
}
