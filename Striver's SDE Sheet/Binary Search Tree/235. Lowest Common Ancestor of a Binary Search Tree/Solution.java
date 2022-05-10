class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null || root == p || root == q )
            return root;
        
        // If both nodes values are lesser than root, than LCA exist in left subtree
        if( p.val < root.val && q.val < root.val ) 
            return lowestCommonAncestor(root.left, p, q);
        
        // If both nodes values are greater than root, than LCA exist in right subtree
        if( p.val > root.val && q.val > root.val ) 
            return lowestCommonAncestor(root.right, p, q);
        
        // One of the nodes is in the left subtree and the other is in right, so the root is the LCA
        return root;
    }
}
