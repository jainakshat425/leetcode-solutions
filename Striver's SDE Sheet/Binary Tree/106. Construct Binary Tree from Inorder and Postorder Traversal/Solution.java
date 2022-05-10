class Solution {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        
        Map<Integer,Integer> inorderMap = new HashMap();
        for(int i=0; i<n; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildTree(postorder, 0, n-1, inorder, 0, n-1, inorderMap);
    }
    
    public TreeNode buildTree(int[] postorder, int poStart, int poEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> inorderMap) {
        
        if( poStart > poEnd || inStart > inEnd )
            return null;
        
        TreeNode root = new TreeNode( postorder[poEnd] );
        int inRoot = inorderMap.get( postorder[poEnd] );
        // Count of numbers after the index of root in inorder array
        int numsRight = inEnd - inRoot;
        
        root.right = buildTree(postorder, poEnd-numsRight, poEnd-1, inorder, inRoot+1, inEnd, inorderMap);
        root.left = buildTree(postorder, poStart, poEnd-numsRight-1, inorder, inStart, inRoot-1, inorderMap);
        
        return root;
    }
}

/*
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
        *
        
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
}*/
