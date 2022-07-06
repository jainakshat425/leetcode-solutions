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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList();
        preorder(root, new ArrayList(), ans);
        return ans;
    }
    
    private void preorder(TreeNode root, List<Integer> path, List<String> ans) {
        
        if( root == null )
            return;
        
        path.add(root.val);
        
        if( root.left == null && root.right == null ) {
            StringBuilder builder = new StringBuilder();
            
            for(int i=0; i<path.size(); i++) {
                builder.append(path.get(i));
                builder.append("->");
            }
            
            ans.add(builder.substring(0, builder.length()-2));
        } else {
            preorder(root.left, path, ans);
            preorder(root.right, path, ans);
        }
        
        path.remove( path.size() - 1 );
    }
}
