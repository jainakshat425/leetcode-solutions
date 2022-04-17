/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {   
        /*
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode curr = head;
        
        while( curr != null ) {
            if( visited.contains( curr ) )  {
                return curr;
            } else {
                visited.add( curr );
                curr = curr.next;
            }
        }
        return null;
        */
        
        /* 
        1. Two pointer Approach
            - Slow pointer {slow} - Moves one node at a time
            - Fast pointer {fast} - Moves two nodes at a time
        2. While there is next node and next's next node
            - Move {slow} pointer one step
            - Move {fast} pointer two steps
            - If {slow} and {fast} pointer points to the same node, then there is a loop.
                - Set {slow} pointer to the {head} node and keep {fast} pointer on the point of intersection.
                - Move both pointers one node at a time until they end up pointing the same node, which is the start point of the cycle.
                - Return one of the pointer.
        */
        
        ListNode slow = head, fast = head;
        
        // While there is next node and next's next node
        while( slow != null && fast != null && fast.next != null ) {
            // Move {slow} pointer one step
            slow = slow.next;
            // Move {fast} pointer two steps
            fast = fast.next.next;
            
            // If {slow} and {fast} pointer points to the same node, then there is a loop.
            if( slow == fast ) {
                
                // Set {slow} pointer to the {head} node and keep {fast} pointer on the point of intersection.
                slow = head;
                
                // Move both pointers one node at a time until they end up pointing the same node, which is the start point of the cycle.
                while( slow != fast ) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                // Return one of the pointer.
                return slow;
            }
        }
        return null;
    }
}
