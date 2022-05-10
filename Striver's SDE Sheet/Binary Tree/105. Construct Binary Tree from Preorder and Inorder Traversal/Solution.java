class Solution {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        
        // Since each node value is unique, hash value to index of inorder array
        Map<Integer,Integer> inorderMap = new HashMap();
        for(int i=0; i<n; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return construct(preorder, 0, n-1, inorder, 0, n-1, inorderMap);
    }
    
    private TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> inorderMap) {
        
        if( preStart > preEnd || inStart > inEnd ) 
            return null;
        
        TreeNode root = new TreeNode( preorder[preStart] );
        
        int inRoot = inorderMap.get( preorder[preStart] );
        // Count of numbers in the left of root
        int numsLeft = inRoot - inStart;
        
        // Recurse for left and right subtree
        root.left = construct(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inorderMap);
        root.right = construct(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inorderMap);
        
        return root;
    }
}
/*
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
        *
        
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
}*/
