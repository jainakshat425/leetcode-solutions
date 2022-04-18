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
    
    private static int[] iOrder;
    private static int[] pOrder;
    private static int postIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /* 
        1. Create pointer {postIndex} pointing to the last element (which is the root of the tree) of the {postorder} array, at any time {postIndex} will point to the element for which new node need has to be created.
        2. Call {construct} for 0 to {postIndex}
            - if {inStart} > {inEnd}, return null.
            - Create a node of value at {postIndex} from {postorder} array and decrement {postIndex}
            - If {inStart} == {inEnd}, then there are no child nodes for current node, return current node {node}.
            - Find the index {inNodeIndex} of current node's value in {inorder} array.
            - Assign the right nodes recursively from {inNodeIndex+1} to {inEnd} (Assigning right node first because we're creating nodes from end of the postOrder array)
            - Assign the left nodes recursively from {inStart} to {inNodeIndex+1}
            - return node
        */
        
        iOrder = inorder;
        pOrder = postorder;
        // Create pointer {postIndex} pointing to the last element (which is the root of the tree) of the {postorder} array, at any time {postIndex} will point to the element for which new node need has to be created.
        postIndex = pOrder.length-1;
        
        // Call {construct} for 0 to {postIndex}
        return construct(0, postIndex);
    }
    
    private TreeNode construct(int inStart, int inEnd) {
        // if {inStart} > {inEnd}, return null.
        if( inStart > inEnd ) {
            return null;
        }
        
        // Create a node of value at {postIndex} from {postorder} array and decrement {postIndex}
        TreeNode node = new TreeNode(pOrder[postIndex]);
        postIndex--;
        
        // If {inStart} == {inEnd}, then there are no child nodes for current node, return current node {node}.
        if( inStart == inEnd ) {
            return node;
        }
        
        // Find the index {inNodeIndex} of current node's value in {inorder} array.
        int inNodeIndex = indexOf( iOrder, node.val, inStart, inEnd );
        
        // Assign the right nodes recursively from {inNodeIndex+1} to {inEnd} (Assigning right node first because we're creating nodes from end of the postOrder array)
        node.right = construct( inNodeIndex+1, inEnd );
        
        // Assign the left nodes recursively from {inStart} to {inNodeIndex+1}
        node.left = construct( inStart, inNodeIndex-1 );
        
        // return node
        return node;
    }
    
    private int indexOf(int[] arr, int val, int start, int end) {
        for(int i=start; i<=end; i++) {
            if( arr[i] == val ) {
                return i;
            }
        }
        return -1;
    }
}
