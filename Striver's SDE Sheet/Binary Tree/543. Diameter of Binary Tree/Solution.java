class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        /* Declare array instead of a primitive to maintain reference instead 
        of using a global variable */
        int[] diameter = new int[1];
        maxDepth(root, diameter);
        return diameter[0];
    }
    
    private int maxDepth(TreeNode root, int[] diameter) {
        if( root == null ) return 0;
        
        // Calculate height of the left subtree
        int left = maxDepth(root.left, diameter);
        // Calculate height of the right subtree
        int right = maxDepth(root.right, diameter);
        
        // Diameter at each node is the sum of heights of left and right subtree
        // Check if diameter sat current node is greater than current diameter
        diameter[0] = Math.max( diameter[0], left+right );
        
        // Return the height at current node
        return Math.max( left, right ) + 1;
    }
}
/*
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if( root == null ) return 0;
        
        // Calculate height of the left subtree
        int leftHeight = maxDepth(root.left);
        // Calculate height of the right subtree
        int rightHeight = maxDepth(root.right);
        
        // Diameter at each node is the sum of heights of left and right subtree
        int diameter = leftHeight + rightHeight;
        
        // Check if a node in the left or right subtree has greater diameter
        diameter = Math.max(diameter, diameterOfBinaryTree(root.left));
        diameter = Math.max(diameter, diameterOfBinaryTree(root.right));
        
        return diameter;
    }
    
    private int maxDepth(TreeNode root) {
        if( root == null ) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max( left, right ) + 1;
    }
}
*/
