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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if( root == null ) return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer( root );
        
        while( !queue.isEmpty() ) {
            
            int size = queue.size();
            
            List<Integer> currLevel = new ArrayList<Integer>();
            result.add( currLevel );
            
            for(int i=0; i<size; i++) {
                
                TreeNode curr = queue.poll();
                
                currLevel.add( curr.val );
                
                if( curr.left != null ) {
                    queue.offer( curr.left );
                }
                if( curr.right != null ) {
                    queue.offer( curr.right );
                }
            }
        }
        
        return result;
    }
}
