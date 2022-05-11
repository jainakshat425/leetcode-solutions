class Solution {
    public int maxSumBST(TreeNode root) {
        int[] max = new int[] { 0 };
        maxSumBST( root, max );
        return max[0];
    }
    
    private Tuple maxSumBST(TreeNode root, int[] max) {
        if( root == null )
            return new Tuple(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        Tuple left = maxSumBST(root.left, max);
        Tuple right = maxSumBST(root.right, max);
        
        // Current tree at root is not BST
        if( left == null || right == null || left.max >= root.val || root.val >= right.min ) 
            return null;
        
        // Current tree at root is BST, check if it has max sum             
        int sum = root.val + left.sum + right.sum;

        max[0] = Math.max( max[0], sum );

        return new Tuple( sum, Math.max(root.val,right.max), Math.min(root.val,left.min) );        
    }
    
    public class Tuple {
        public int sum;
        public int max;
        public int min;
        
        public Tuple(int sum, int max, int min) {
            this.sum = sum;
            this.max = max;
            this.min = min;
        }
    }
}
/*
class Solution {
    public int maxSumBST(TreeNode root) {
        int[] max = new int[] { 0 };
        isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, new int[]{ 0 }, max);
        return max[0];
    }
    
    private boolean isBST(TreeNode root, int minVal, int maxVal, int[] sum, int[] max) {
        if( root == null )
            return true;
        
        int[] leftSum = new int[]{ 0 };
        boolean isLeftBST = isBST(root.left, minVal, root.val, leftSum, max);
        
        int[] rightSum = new int[]{ 0 };
        boolean isRightBST = isBST(root.right, root.val, maxVal, rightSum, max);
        
        if( !isLeftBST || !isRightBST || root.val <= minVal || root.val >= maxVal )
            return false;
        
        sum[0] = root.val + leftSum[0] + rightSum[0];
        max[0] = Math.max(max[0], sum[0]);
        
        return isLeftBST && isRightBST;
    }
}
*/
/*
class Solution {
    public int maxSumBST(TreeNode root) {
        return maxSumBST(root, 0);
    }
    
    private int maxSumBST(TreeNode root, int max) {
        if( root == null )
            return max;
        
        int[] sum = new int[]{ 0 };
        
        if( isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, sum) ) {
            max = Math.max(max, sum[0]);
        } 
        
        return Math.max(maxSumBST(root.left, max), maxSumBST(root.right, max));
    }
    
    private boolean isBST(TreeNode root, int minVal, int maxVal, int[] sum) {
        if( root == null )
            return true;
        
        if( root.val <= minVal || root.val >= maxVal )
            return false;
        
        sum[0] += root.val;
        
        return isBST(root.left, minVal, root.val, sum) && isBST(root.right, root.val, maxVal, sum);
    }
}
*/
