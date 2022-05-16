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
    public int deepestLeavesSum(TreeNode root) {
        int[] maxLevel = new int[] { 0 };
        int[] sum = new int[] { 0 };
        deepestLeavesSum(root, 0, maxLevel, sum);
        return sum[0];
    }
    
    private void deepestLeavesSum(TreeNode node, int height, int[] maxLevel, int[] sum) {
        if( node == null )
            return;
        
        deepestLeavesSum(node.left, height+1, maxLevel, sum);
        deepestLeavesSum(node.right, height+1, maxLevel, sum);
        
        if( height == maxLevel[0] ) {
            sum[0] += node.val;
        }
        if( height > maxLevel[0] ) {
            maxLevel[0] = height;
            sum[0] = node.val;
        }
    }
    
    /*
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer( root );
        
        while( !queue.isEmpty() ) {
            sum = 0;
            
            int n = queue.size();
            
            while( n-- > 0 ) {
                TreeNode curr = queue.poll();
                
                sum += curr.val;
                
                if( curr.left != null )
                    queue.offer( curr.left );
                if( curr.right != null )
                    queue.offer( curr.right );
            }
        }
        return sum;
    }*/
}
