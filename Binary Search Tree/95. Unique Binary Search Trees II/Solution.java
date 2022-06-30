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
    public List<TreeNode> generateTrees(int n) {
        return generateBST(1, n);
    }
    
    private List<TreeNode> generateBST(int start, int end) {
        if( start > end )
            return new ArrayList(){{ add(null); }};
        
        List<TreeNode> roots = new ArrayList();
        
        for(int node=start; node<=end; node++) {
            
            List<TreeNode> leftBSTs = generateBST(start, node-1);
            List<TreeNode> rightBSTs = generateBST(node+1, end);
            
            for(TreeNode left : leftBSTs) {
                for(TreeNode right : rightBSTs) {
                    TreeNode root = new TreeNode(node);
                    root.left = left;
                    root.right = right;
                    roots.add(root);
                }
            }
        }
        return roots;
    }
}
