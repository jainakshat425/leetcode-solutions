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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        /* 
        1. Top down approach - At each node, calculate sum from root till the node.
        2. Call {hasPathSum} with {root}, {targetSum} and {sum} intitialized to 0.
        3. If {curr} is null return false.
        4. Calculate sum till current node.
        5. If current node {curr} is a leaf node, return {sum} == {targetSum}
        6. Check if the left path has the required {targetSum} or the right path.
        */
        
        // Call {hasPathSum} with {root}, {targetSum} and {sum} intitialized to 0.
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode curr, int targetSum, int sum) {
        // If {curr} is null return false.
        if( curr == null ) return false;
        
        // Calculate sum till current node.
        sum += curr.val;
        
        // If current node {curr} is a leaf node, return {sum} == {targetSum}
        if( curr.left == null && curr.right == null ) {
            return sum == targetSum;
        }
        
        // Check if the left path has the required {targetSum} or the right path.
        return hasPathSum(curr.left, targetSum, sum) || hasPathSum(curr.right, targetSum, sum);
    }
}
