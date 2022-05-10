class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        
        while( curr != null ) {
            
            // Backup the right node in stack
            if( curr.right != null ) 
                stack.push( curr.right );
            
            /* If there is a left node of current node, make it right node, else
            add the right node from the stack's top */
            curr.right = curr.left == null && !stack.isEmpty() ? stack.pop() : curr.left; 
            
            curr.left = null;
            
            curr = curr.right;
        }
    }
}
