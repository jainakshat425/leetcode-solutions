class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root) != -1;
    }
    
    private int checkBalanced(TreeNode root) {
        if( root == null ) return 0;
        
        /* Get the height of the left and right subtree, while checking each 
        node in left and right subtree are balanced or not */
        int left = checkBalanced(root.left);
        if( left == -1 ) return -1;
        
        int right = checkBalanced(root.right);
        if( right == -1 ) return -1;
        
        /* If the differnce in height of left and right subtree is more than 1 
        tree is not balanced, return -1 */
        if( Math.abs(left-right) > 1 ) return -1;
        
        return Math.max(left, right) + 1;
    }
}
