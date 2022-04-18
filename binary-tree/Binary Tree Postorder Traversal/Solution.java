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
    public List<Integer> postorderTraversal(TreeNode root) {
        /* 
                1
            2      5
          3  4   6
          
        3 4 2 6 5 1
        result = [3,4,2]
        stack = []
        curr = 5
        prev = 2
        */
        /* 
        1. Declare 
            - {result} - Stores the post order traversal of the tree
            - {stack} - Stores the traversed nodes, used for backtracking
            - pointers {curr} and {prev} - Point to the current node and last processed node.
        2. Repeat while {curr} != null OR {stack} is not empty
            - if {curr} != null, push {curr} node into stack and move the pointer to the left node.
            - else
                - Copy the top node from {stack} into {curr}.
                - If {curr} has no right child or the right child is already processed
                    - Add curr node's val to the {result}
                    - Remove the {curr} element from stack
                    - {prev} will point to the {curr} node as {curr} is processed.
                    - Set {curr} to null
                - else current node has right child and it's not processed
                    - move {curr} to the right child.
        */
        
        // {result} - Stores the post order traversal of the tree
        List<Integer> result = new ArrayList<Integer>();
        
        // {stack} - Stores the traversed nodes, used for backtracking
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        // pointers {curr} and {prev} - Point to the current node and last processed node.
        TreeNode curr = root, prev = null;
        
        // Repeat while {curr} != null OR {stack} is not empty
        while( curr != null || !stack.isEmpty() ) {
            
            // if {curr} != null, push {curr} node into stack and move the pointer to the left node.
            if( curr != null ) {
                stack.push( curr );
                curr = curr.left;
            } else {
                // Copy the top node from {stack} into {curr}.
                curr = stack.peek();
                
                // if {curr} has no right child or the right child is already processed
                if( curr.right == null || curr.right == prev ) {
                    
                    // Add curr node's val to the {result}
                    result.add( curr.val );
                    
                    // Remove the {curr} element from stack
                    stack.pop();
                    
                    // {prev} will point to the {curr} node as {curr} is processed.
                    prev = curr;
                    curr = null;
                } else {
                    // else current node has right child and it's not processed
                    // move {curr} to the right child.
                    curr = curr.right;
                }
            }
        }
        // recursivePostOrder(result, root);
        return result;
    }
    
    private void recursivePostOrder(List<Integer> result, TreeNode curr) {
        if( curr == null ) return;
        
        recursivePostOrder(result, curr.left);
        recursivePostOrder(result, curr.right);
        result.add(curr.val);
    }
}
