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
    public ListNode removeElements(ListNode head, int val) {
        /* 
        1. Move pointer {curr} from {head} to the last node
            - if current has value == {val}, delete the node
                - If {prev} is null, delete {head} node
                - else delete {curr} node, by making {prev.next} point to the next of the current node {curr.next}
            - else move {prev} to the {curr}, iff {curr} is not being deleted
            - Move {curr} to the next node.
        */
        ListNode prev = null, curr = head;

        // Move pointer {curr} from {head} to the last node
        while( curr != null ) {
            
            // if current has value == {val}, delete the node
            if( curr.val == val ) {
                
                // If {prev} is null, delete {head} node
                if( prev == null ) {
                    head = head.next;
                } else {
                    // else delete {curr} node, by making {prev.next} point to the next of the current node {curr.next}
                    prev.next = curr.next;
                }
            } else {
                // else move {prev} to the {curr}, iff {curr} is not being deleted
                prev = curr;
            }
            // Move {curr} to the next node.
            curr = curr.next;
        }
        
        return head;
    }
}
