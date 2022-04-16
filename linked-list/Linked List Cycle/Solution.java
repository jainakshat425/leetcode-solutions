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
    public boolean hasCycle(ListNode head) {
        /* 
        1. Two pointer Approach
            - Slow pointer {slow} - Moves one step at a time
            - Fast pointer {fast} - Moves two steps at a time
        2. While there is next node and next's next node
            - Move slow pointer one step
            - Move fast pointer two steps
            - If slow and fast pointer points to the same node, then there is a loop.
        */
        ListNode slow = head, fast = head;

        // While there is next node and next's next node
        while( slow != null && fast != null && fast.next != null ) {
            // Move slow pointer one step
            slow = slow.next;
            // Move fast pointer two steps
            fast = fast.next.next;
            
            // If slow and fast pointer points to the same node, then there is a loop.
            if( slow == fast ) {
                return true;
            }
        }
        
        return false;
    }
}
