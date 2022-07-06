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
// class Solution {
//     public void recoverTree(TreeNode root) {
//         // First violation, adjacent node to first violation, second violation
//         TreeNode first = null, adj = null, second = null;
//         TreeNode curr = root, prev = new TreeNode(Integer.MIN_VALUE);
//         Stack<TreeNode> stack = new Stack();
        
//         while( !stack.isEmpty() || curr != null ) {
            
//             while( curr != null ) {
//                 stack.push(curr);
//                 curr = curr.left;
//             }
            
//             curr = stack.pop();
            
//             if( prev != null && curr.val < prev.val ) {
//                 if( first == null ) {
//                     first = prev;
//                     adj = curr;
//                 } else {
//                     second = curr;
//                     break;
//                 }
//             }
//             prev = curr;
            
//             curr = curr.right;
//         }
        
//         if( second != null ) 
//             swap(first, second);
//         else
//             swap(first, adj);
//     }
    
//     private void swap(TreeNode node1, TreeNode node2) {
//         int temp = node1.val;
//         node1.val = node2.val;
//         node2.val = temp;
//     }
// }
class Solution {
    public void recoverTree(TreeNode root) {
        // First violation, second violation
        TreeNode first = null, second = null;
        TreeNode curr = root, prev = new TreeNode(Integer.MIN_VALUE);
        
        while( curr != null ) {
            
            if( curr.left == null ) {
                if( prev != null && curr.val < prev.val ) {
                    if( first == null ) 
                        first = prev;
                    second = curr;
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while( temp.right != null && temp.right != curr )
                    temp = temp.right;
                
                if( temp.right == curr ) {
                    if( prev != null && curr.val < prev.val ) {
                        if( first == null ) 
                            first = prev;
                        second = curr;
                    }
                    prev = curr;
                    temp.right = null;
                    curr = curr.right;
                } else {
                    // link right most node in left subtree to curr node (root)
                    temp.right = curr;
                    curr = curr.left;
                }
            }
        }
        swap(first, second);
    }
    
    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
