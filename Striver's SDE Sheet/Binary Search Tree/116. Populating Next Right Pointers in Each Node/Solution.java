class Solution {
    public Node connect(Node root) {
        
        if(root == null) return null;
        
        Node levelStart = root;
        
        // Iterate for each level
        while( levelStart != null ) {
            
            // Iterate for each node in current level
            Node curr = levelStart;
            
            while( curr != null ) {
            
                // Check left != null is sufficient because it's perfect binary tree 
                if( curr.left != null ) {
                    curr.left.next = curr.right;
                    curr.right.next = curr.next != null ? curr.next.left : null;
                }
                
                curr = curr.next;
            }
            // Move to the first node of the next level
            levelStart = levelStart.left;
        }
        
        return root;
    }
}
/*
class Solution {
    public Node connect(Node root) {
        
        if(root == null) return null;
        
        // Create a queue for level order traversal
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer( root );
        
        // Iterate for each level
        while( !queue.isEmpty() ) {
            
            int size = queue.size();
            
            // Iterate for each node in current level
            for(int i=0; i<size; i++) {
                
                Node curr = queue.poll();
                
                /* If current node is not the last node of the current level, 
                set the next of current node *
                if( i != size-1 ) 
                    curr.next = queue.peek();
                
                // Check left != null is sufficient because it's perfect binary tree 
                if( curr.left != null ) {
                    queue.offer( curr.left );
                    queue.offer( curr.right );
                }
            }
        }
        
        return root;
    }
}*/
/*
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
     
        // Call {connect} for root's left and right
        connect(root.left, root.right);
        
        return root;
    }
    
    public void connect(Node left, Node right) {
        // Since it's perfect binary checking left is null is sufficient for base condition.
        if( left == null ) return;
        
        // Set left's next {left.next} pointer to {right} node.
        left.next = right;
        
        // Call {connect} for left's left and right, left's right and right's left, and right's left and right.
        connect(left.left, left.right);
        connect(left.right, right.left);
        connect(right.left, right.right);
    }
}*/
