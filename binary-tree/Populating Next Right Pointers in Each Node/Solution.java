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
        
        /*
        if(root == null) return null;
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
                    queue.offer( curr.right );
                }
            }
        }*/
        
        /* 
        1. Top down recursive approach
        2. Call {connect} for root's left and right
        3. Since it's perfect binary checking left is null is sufficient for base condition.
        4. Set left's next {left.next} pointer to {right} node.
        5. Call {connect} for left's left and right, left's right and right's left, and right's left and right.
        */
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
}
