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
    public TreeNode recoverFromPreorder(String traversal) {
        int n = traversal.length();
        Deque<TreeNode> stack = new LinkedList();
        
        for(int i = 0; i < n; ) {
            int level = 0, val = 0;
            
            for(; traversal.charAt(i) == '-'; i++) 
                level++;
                            
            for(; i < n && traversal.charAt(i) != '-'; i++) 
                val = val * 10 + (traversal.charAt(i) - '0');
            
            while( stack.size() > level )
                stack.pollLast();
            
            TreeNode newNode = new TreeNode(val);
            
            if( !stack.isEmpty() ) {
                TreeNode parent = stack.peekLast();
                
                if( parent.left == null )
                    parent.left = newNode;
                else
                    parent.right = newNode;
            }
            stack.offerLast(newNode);
        }
        return stack.peekFirst();
    }
}
