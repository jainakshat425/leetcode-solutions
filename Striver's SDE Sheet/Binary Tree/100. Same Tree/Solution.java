class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If one of the node is null, then both of them should be null
        if( p == null || q == null )
            return p == q;
        
        // If value of current nodes are not same return false.
        if( p.val != q.val )
            return false;
        
        // Current nodes are same, check if left and right subtree are same
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
