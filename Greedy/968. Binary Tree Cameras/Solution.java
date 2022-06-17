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
    
    public enum State {HAS_CAMERA, COVERED, NOT_COVERED};
    
    public int minCameraCover(TreeNode root) {
        int[] ans = new int[]{ 0 };
        return minCamera(root, ans) == State.NOT_COVERED ? ans[0] + 1 : ans[0];
    }
    
    private State minCamera(TreeNode node, int[] ans) {
        if( node == null )
            return State.COVERED;
        
        State left = minCamera(node.left, ans);
        State right = minCamera(node.right, ans);
        
        if( left == State.NOT_COVERED || right == State.NOT_COVERED ) {
            ans[0]++;
            return State.HAS_CAMERA;
        }
        
        if( left == State.HAS_CAMERA || right == State.HAS_CAMERA ) 
            return State.COVERED;
        
        return State.NOT_COVERED;
    }
           
}
/*
class Solution {
    public int minCameraCover(TreeNode root) {
        Set<TreeNode> covered = new HashSet(){{ add(null); }};
        int[] ans = new int[]{ 0 };
        minCamera(root, null, covered, ans);
        return ans[0];
    }
    
    private void minCamera(TreeNode node, TreeNode parent, Set<TreeNode> covered, int[] ans) {
        if( node == null )
            return;
        
        minCamera(node.left, node, covered, ans);
        minCamera(node.right, node, covered, ans);
        
        if( 
            (parent == null && !covered.contains(node)) || 
           !covered.contains(node.left) ||
           !covered.contains(node.right)
        ) {
            ans[0]++;
            
            covered.add(parent);
            covered.add(node);
            covered.add(node.left);
            covered.add(node.right);
        }
    }
           
}
*/
