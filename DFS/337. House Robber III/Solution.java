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
    public int rob(TreeNode root) {
        // 0 > Don't rob root, 1 > rob root
        int[] ans = robMax(root);
        return Math.max(ans[0], ans[1]);
    }
    
    private int[] robMax(TreeNode root) {
        if( root == null )
            return new int[]{ 0, 0 };

        int[] left = robMax(root.left);
        int[] right = robMax(root.right);
        
        return new int[]{
            // don't rob current node
            Math.max(left[0], left[1]) + Math.max(right[0], right[1]),
            // rob current node
            root.val + left[0] + right[0]
        };
    }
}
// class Solution {
//     public int rob(TreeNode root) {
//         // TreeNode -> [max for canRob = false, max for canRob = true]
//         Map<TreeNode,Integer[]> memo = new HashMap();
//         return rob(root, 1, memo);
//     }
    
//     private int rob(TreeNode root, int canRob, Map<TreeNode,Integer[]> memo) {
//         if( root == null )
//             return 0;
        
//         memo.putIfAbsent(root, new Integer[2]);
//         Integer[] maxRob = memo.get(root);
        
//         if( maxRob[canRob] == null ) {
//             int skip = rob(root.left, 1, memo) + rob(root.right, 1, memo);

//             int rob = 0;
//             if( canRob == 1 )
//                 rob = root.val + rob(root.left, 0, memo) + rob(root.right, 0, memo);
            
//             maxRob[canRob] = Math.max(skip, rob);
//         }
        
//         return maxRob[canRob];
//     }
// }
