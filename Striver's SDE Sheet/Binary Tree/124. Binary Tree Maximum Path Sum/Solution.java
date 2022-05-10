class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[] { Integer.MIN_VALUE };
        maxPathSum(root, max);
        return max[0];
    }
    
    private int maxPathSum(TreeNode root, int[] max) {
        if( root == null ) 
            return 0;
        
        // If any of the left or right path sum is negative then discard that path
        int lsum = Math.max(0, maxPathSum(root.left, max));
        int rsum = Math.max(0, maxPathSum(root.right, max));
          
        max[0] = Math.max(max[0], root.val + lsum + rsum);
        
        return root.val + Math.max(lsum, rsum);
    }
}
