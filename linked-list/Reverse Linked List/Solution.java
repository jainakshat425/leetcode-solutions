/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        /* 
        1. If list has no nodes return null.
        2. While there is a next node in the list, move the next node in the list to the {head} pointer.
            - Get the next node of {curr} node in a temporary pointer {newHead}
            - Make {curr.next} point to the next node of the {neadHead}
            - New head node's next {newHead.next} should be current head {head}.
            - Make {head} points to {newHead}
        */
        // If list has no nodes return null.
        if( head == null ) {
            return null;
        }
        
        ListNode curr = head;
        
        // While there is a next node in the list, move the next node in the list to the {head} pointer.
        while( curr.next != null ) {
            // Get the next node of {curr} node in a temporary pointer {newHead}
            ListNode newHead = curr.next;
            // Make {curr.next} point to the next node of the {neadHead}
            curr.next = newHead.next;
            // New head node's next {newHead.next} should be current head {head}.
            newHead.next = head;
            // Make {head} points to {newHead}
            head = newHead;
        }
        
        return head;
    }
}
