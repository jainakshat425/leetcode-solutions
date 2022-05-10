class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if( node == null ) 
            return;
            
        // Swap left and right nodes
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        // Mirror left and right subtree
        mirror(node.left);
        mirror(node.right);
    }
    
}
