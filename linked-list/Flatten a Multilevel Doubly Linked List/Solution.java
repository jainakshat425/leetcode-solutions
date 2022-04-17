/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        /* 
        1. Create a backup stack {stack} to backup next node when a child is made next node of current node.
        2. Repeat from head to the last node
            - If there is a child node of the current node {curr}
                - Backup current's next node {curr.next} into the stack.
                - Make child node {curr.child} current node's next {curr.next}.
                - Make current node {curr} child's previous node.
                - Remove the pointer to the child.
            - Else current node has no child and if there is no next node, check the backup stack {stack} to merge back the abondoned nodes.        
        */
        
        // Create a backup stack {stack} to backup next node when a child is made next node of current node.
        Stack<Node> stack = new Stack<Node>();
        Node curr = head;
        
        // Repeat from head to the last node
        while( curr != null ) {
            
            // If there is a child node of the current node {curr}
            if( curr.child != null ) {
                
                // Backup current's next node {curr.next} into the stack.
                if( curr.next != null ) {
                    stack.push( curr.next );
                }
                
                // Make child node {curr.child} current node's next {curr.next}.
                curr.next = curr.child;
                // Make current node {curr} child's previous node.
                curr.child.prev = curr;
                // Remove the pointer to the child.
                curr.child = null;
                
            } else if( curr.next == null && !stack.isEmpty() ) {
                // Else current node has no child and if there is no next node, check the backup stack {stack} to merge back the abondoned nodes.        
                curr.next = stack.pop();
                curr.next.prev = curr;
            }
            
            curr = curr.next;
        }
        
        return head;
    }
}
