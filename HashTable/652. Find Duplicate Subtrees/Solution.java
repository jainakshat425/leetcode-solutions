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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList();
        Map<String,Integer> seen = new HashMap();
        dfs(root, seen, ans);
        return ans;
    }
    
    private String dfs(TreeNode node, Map<String,Integer> seen, List<TreeNode> ans) {
        if( node == null )
            return "#";
        
        StringBuilder builder = new StringBuilder();
        builder.append(node.val);
        builder.append(",");
        builder.append( dfs(node.left, seen, ans) ); 
        builder.append(",");
        builder.append( dfs(node.right, seen, ans) ); 
        
        String subtree = builder.toString();
        int seenCount = seen.getOrDefault(subtree, 0) + 1;
        seen.put(subtree, seenCount);
        
        if( seenCount == 2 )
            ans.add(node);
        
        return subtree;
    }
}
