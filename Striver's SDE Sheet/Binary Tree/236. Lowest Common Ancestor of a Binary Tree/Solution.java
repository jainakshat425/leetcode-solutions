class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Return if reached end of the tree or any of the node is found
        if( root == null || root.val == p.val || root.val == q.val ) {
            return root;
        }
        
        // Check if any of of the node exist in left subtree
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        // Check if any of of the node exist in right subtree
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        
        /* If the nodes are found in left and right subtree of current 
        node, then current node is the LCA */
        if( leftLCA != null && rightLCA != null ) {
            return root;
        }
        
        // Return the node which is found in current path
        return leftLCA != null ? leftLCA : rightLCA;
    }
    
    /*
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         
        // Push the path to node first node into stack1.
        // Push the path to the second node into stack2.
        // Find the difference in sizes of stack and remove the extra nodes from larger stack.
        // Once sizes of both the stacks are equal keep poping nodes from both the stacks simultaneously.
        // If popped nodes are equal, return the node.
        
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        
        findPath( stack1, root, p.val );
        findPath( stack2, root, q.val );
        
        if( stack1.size() > stack2.size() ) {
            popN(stack1, stack1.size() - stack2.size());
        } else if( stack2.size() > stack1.size() ) {
            popN(stack2, stack2.size() - stack1.size());
        }
        
        while( stack1.peek() != stack2.peek() ) {
            stack1.pop();
            stack2.pop();
        }
        
        return stack1.pop();
    }

    private void popN(Stack<TreeNode> stack, int n) {
        while(n-- > 0) {
            stack.pop();
        }
    }
    
    private Boolean findPath(Stack<TreeNode> path, TreeNode root, int val) {
        if( root == null ) return false;
        
        path.push( root );
        
        if( root.val == val ) {
            return true;
        }
        
        if( findPath(path, root.left, val) ) {
            return true;
        } else if( findPath(path, root.right, val) ) {
            return true;
        } else {
            path.pop();
            return false;
        }
    }
    */
}
