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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        int size = 0;
        ListNode curr = head, prev;
        
        while( curr != null ) {
            curr = curr.next;
            size++;
        }

        // Node to be deleted
        curr = head;
        // Node previous to the node to be deleted
        prev = null;
        
        for(int i=0; i<(size-n); i++) {
            prev = curr;
            curr = curr.next;
        }
        
        if( prev == null ) {
            head = curr.next;
        } else {
            prev.next = curr.next;
        }
        curr.next = null;
        
        return head;
        */
        /* 
        1. Move {second} pointer  to the {n}th position from start.
        2. If {second} pointer is pointing to null, head node needs to be deleted.
        3. else move {first} pointer until {second} pointer reaches the last node.
        4. When {second} pointer reaches the last node, {first} pointer will be pointing to the node previous to the {n}th node from last.
        5. Delete node next to the {first} node.
        */
        
        ListNode second = head;
        
        // Move {second} pointer  to the {n}th position from start.
        for(int i=0; i<n; i++) {
            second = second.next;
        }
        
        // If {second} pointer is pointing to null, head node needs to be deleted.
        if( second == null ) {
            head = head.next;
        } else {
            ListNode first = head;
            
            // else move {first} pointer until {second} pointer reaches the last node.
            // When {second} pointer reaches the last node, {first} pointer will be pointing to the node previous to the {n}th node from last.
            while( second.next != null ) {
                first = first.next;
                second = second.next;
            }
            
            // Delete node next to the {first} node.
            first.next = first.next.next;
        }
        
        return head;
    }
}
