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
    public int getMinimumDifference(TreeNode root) {            
        /* 
                100
             50     150
          25   99       170
        
        25 50 99 100 150 170
        
        50 100
        25 50
        99 50
        150 100
        170 150ac
        */
        int prev = -1;
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        
        while( !stack.isEmpty() || curr != null ) {
            
            while( curr != null ) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            
            if( prev != -1 )
                min = Math.min(min, curr.val - prev);
            
            prev = curr.val;
            
            curr = curr.right;
        }
        
        return min;
    }
}
