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
    public int pathSum(TreeNode root, int targetSum) {
        int ans = 0;       
        Map<Integer,Integer> sumCount = new HashMap(){{ put(0,1); }};
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root, prev = null;
        int sum = 0;
        
        while( !stack.isEmpty() || curr != null ) {
            if( curr != null ) {
                sum += curr.val;
                
                ans += sumCount.getOrDefault(sum - targetSum, 0);
                
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
                
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.peek();
                
                if( curr.right == null || curr.right == prev ) {            
                    
                    sumCount.put(sum, sumCount.get(sum) - 1);
                    
                    prev = stack.pop();
                    sum -= prev.val;
                    
                    curr = null;
                } else 
                    curr = curr.right;
            }
        }
        return ans;
    }
}












