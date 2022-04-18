/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        /*
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer( root );
        
        while( !queue.isEmpty() ) {
            
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                Node curr = queue.poll();
                if( i != size-1 ) {
                    curr.next = queue.peek();
                }
                
                if( curr.left != null ) {
                    queue.offer( curr.left );
                }
                if( curr.right != null ) {
                    queue.offer( curr.right );
                }
                 
            }
        }*/
        
        // connect(root.left, root.right);

        /* 
        1. Create pointer {parent} pointing to root
        2. Repeat for each level while {parent} is not null
            - Create a dummy head node for current level {dummyHead}
            - Create a pointer {curr} to point to current processing node of current level
            - Repeat if there is a node in current level  (parent node's level)
                - If {parent} has a left child, current's next will be parent's left child and move {curr} to the next node.
                - Similarly, if {parent} has a right child, current's next will be parent's right child and move {curr} to the next node.
                - Move {parent} to the next node in current level {parent.next}
            - Move {parent} to the first node of next level {dummyHead.next}
        */
        // Create pointer {parent} pointing to root
        Node parent = root;
        
        // Repeat for each level while {parent} is not null
        while( parent != null ) {
            
            // Create a dummy head node for current level {dummyHead}
            Node dummyHead = new Node(-1);
            // Create a pointer {curr} to point to current processing node of current level
            Node curr = dummyHead;
            
            // Repeat if there is a node in current level  (parent node's level)
            while( parent != null ) {
                
                // If {parent} has a left child, current's next will be parent's left child and move {curr} to the next node.
                if( parent.left != null ) {
                    curr.next = parent.left;
                    curr = curr.next;
                }
                
                // Similarly, if {parent} has a right child, current's next will be parent's right child and move {curr} to the next node.
                if( parent.right != null ) {
                    curr.next = parent.right;
                    curr = curr.next;
                }
                
                // Move {parent} to the next node in current level {parent.next}
                parent = parent.next;
            }
            // Move {parent} to the first node of next level {dummyHead.next}
            parent = dummyHead.next;
        }
        return root;
    }
    /* 
    Not working
    private void connect(Node left, Node right) {
        if( left == null && right == null ) return;
        
        if( left != null ) {
            
            left.next = right;
            
            if( left.right != null ) {
                connect(left.left, left.right);
            } else if( right != null ) {
                connect(left.left, right.left != null ? right.left : right.right);
            }
            
            if( right != null ) {
                connect(left.right, right.left != null ? right.left : right.right);
                connect(right.left, right.right);
            } 
        } else {
            connect(right.left, right.right);
        }
    }
    */
}
