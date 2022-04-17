/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        /*
        if( head == null ) {
            return null;
        }
        
        Map<Node,Node> originalToCloneMap = new HashMap<Node,Node>();
        Node curr = head;
        
        while( curr != null ) {            
            originalToCloneMap.put(curr, new Node( curr.val ));
            curr = curr.next;
        }
        
        curr = head;
        
        while( curr != null ) {
            Node clone = originalToCloneMap.get( curr );
            clone.next = originalToCloneMap.get( curr.next );
            clone.random = originalToCloneMap.get( curr.random );
            
            curr = curr.next;
        }
        
        return originalToCloneMap.get( head );
        */
        
        /* 
        1. Create clone of each original node and insert it just after the original node.
        2. Head of the cloned list will be just next to the head of the original list.
        3. Adjust the random pointers
            - For each cloned node, random node will be next to the original random node (original random node can be null)
            - Move {curr} to the next original node
        4. Fix the next pointers of original list and cloned list
            - For each original node, next node will be next to the next cloned node
            - Similarly, for each cloned node, next node will be next to the next original node
            - Move {curr} to the next original node (no need to move two nodes, as next pointer is already fixed)
        */
        if( head == null ) {
            return null;
        }
        
        Node curr = head;

        // Create clone of each original node and insert it just after the original node.
        while( curr != null ) {    
            Node clone = new Node(curr.val);
            
            clone.next = curr.next;
            curr.next = clone;
            
            curr = curr.next.next;
        }
        
        // Head of the cloned list will be just next to the head of the original list.
        Node cloneHead = head.next;
        
        curr = head;
        
        // Adjust the random pointers
        while( curr != null ) {
            // For each cloned node, random node will be next to the original random node (original random node can be null) 
            curr.next.random = curr.random != null ? curr.random.next : null;
            // Move {curr} to the next original node
            curr = curr.next.next;
        }
        
        
        curr = head;
        // Fix the next pointers of original list and cloned list
        while( curr != null ) {
            
            Node clone = curr.next;
            // For each original node, next node will be next to the next cloned node
            curr.next = clone.next;
            
            // Similarly, for each cloned node, next node will be next to the next original node
            clone.next = clone.next != null ? clone.next.next : null;
            
            // Move {curr} to the next original node (no need to move two nodes, as next pointer is already fixed)
            curr = curr.next;
        }
        
        return cloneHead;
    }
}
