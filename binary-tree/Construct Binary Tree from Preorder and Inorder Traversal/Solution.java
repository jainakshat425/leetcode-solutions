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
    private static int[] pOrder;
    private static int[] iOrder;
    private static int preIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         /* 
        1. Create pointer {preIndex} pointing to the first element (which is the root of the tree) of the {preorder} array, at any time {preIndex} will point to the element for which new node need has to be created.
        2. Call {construct} for 0 to last index of {preorder}
            - if {inStart} > {inEnd}, return null.
            - Create a node of value at {preIndex} from {preorder} array and increment {preIndex}
            - If {inStart} == {inEnd}, then there are no child nodes for current node, return current node {node}.
            - Find the index {inNodeIndex} of current node's value in {inorder} array.
            - Assign the left nodes recursively from {inStart} to {inNodeIndex+1} (Assigning left node first because we're creating nodes from start of the preOrder array)
            - Assign the right nodes recursively from {inNodeIndex+1} to {inEnd} 
            - return node
        */
        
        pOrder = preorder;
        iOrder = inorder;
        // Create pointer {preIndex} pointing to the first element (which is the root of the tree) of the {preorder} array, at any time {preIndex} will point to the element for which new node need has to be created.
        preIndex = 0;
        
        // Call {construct} for 0 to last index of {preorder}
        return construct(0, pOrder.length-1);
    }
    
    private TreeNode construct(int inStart, int inEnd) {
        
        // if {inStart} > {inEnd}, return null.
        if( inStart > inEnd ) return null;
        
        // Create a node of value at {preIndex} from {preorder} array and increment {preIndex}
        TreeNode node = new TreeNode(pOrder[preIndex]);
        preIndex++;
        
        // If {inStart} == {inEnd}, then there are no child nodes for current node, return current node {node}.
        if( inStart == inEnd ) {
            return node;
        }
        
        // Find the index {inNodeIndex} of current node's value in {inorder} array.
        int inNodeIndex = indexOf( iOrder, node.val, inStart, inEnd );
        
        // Assign the left nodes recursively from {inStart} to {inNodeIndex+1} (Assigning left node first because we're creating nodes from start of the preOrder array)
        node.left = construct( inStart, inNodeIndex-1 );
        
        // Assign the right nodes recursively from {inNodeIndex+1} to {inEnd} 
        node.right = construct( inNodeIndex+1, inEnd );
        
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
