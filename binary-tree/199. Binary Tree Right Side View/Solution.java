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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList();
        rightView(root, 0, ans);
        return ans;
    }
    
    private void rightView(TreeNode node, int currLevel, List<Integer> ans) {
        if( node == null )
            return;
        
        if( currLevel == ans.size() ) {
            ans.add(node.val);
        }
        
        rightView(node.right, currLevel+1, ans);
        rightView(node.left, currLevel+1, ans);
    }
}
