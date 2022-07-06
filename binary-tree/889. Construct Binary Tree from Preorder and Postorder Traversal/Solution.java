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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        /* 
        preorder  = [1,2,4,5,3,6,7]
        postorder = [4,5,2,6,7,3,1]
        
        preorder  = Root L R
        postorder = L R Root
        */
        int n = preorder.length;
        Map<Integer,Integer> postInd = new HashMap();
        for(int i=0; i<n; i++)
            postInd.put(postorder[i], i);
        return construct(0, n-1, 0, n-1, preorder, postorder, postInd);
    }
    
    private TreeNode construct(int preStart, int preEnd, int postStart, int postEnd, int[] preorder, int[] postorder, Map<Integer,Integer> postInd) {
        if( preStart > preEnd )
            return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        preStart++;
        postEnd--;

        if( preStart > preEnd )
            return root;

        if( preorder[preStart] == postorder[postEnd] )
            root.left = construct(preStart, preEnd, postStart, postEnd, preorder, postorder, postInd);
        else {
            int pivot = postInd.get(preorder[preStart]);
            int numsLeft = pivot - postStart;

            root.left = construct(preStart, preStart+numsLeft, postStart, pivot, 
                                  preorder, postorder, postInd);
            root.right = construct(preStart+numsLeft+1, preEnd, pivot+1, postEnd, 
                                   preorder, postorder, postInd);
        }
        return root;
    }
}
