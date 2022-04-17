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
    public ListNode rotateRight(ListNode head, int k) {
        /* 
        Input: head = [1,2,3,4,5], k = 2
        Output: [4,5,1,2,3]
        
        [1,2] 1
        */
        /* 
        1. Calculate {size} of linked list and move pointer {last} to the last node.
        2. Calculate minimum required rotations by taking mod of {k} by {size}.
        3. If {k} is 0, no rotations required, return head of the node.
        4. Move {curr} to {size-k-1}th index, this will be the new last node after {k} rotation.
        5. Fix pointers to complete the rotation 
            - last node's next {last.next} will be the current head node {head}
            - {curr.next} will be the new head node
            - {curr} will be the new last node and it's will point to null
        */
        if( head == null ) return null;
        
        int size = 1;
        ListNode last = head;
        
        // Calculate {size} of linked list and move pointer {last} to the last node.
        while( last.next != null ) {
            last = last.next;
            size++;
        }
        
        // Calculate minimum required rotations by taking mod of {k} by {size}.
        k %= size;
        
        // If {k} is 0, no rotations required, return head of the node.
        if( k == 0 ) return head;
        
        ListNode curr = head;
        
        // Move {curr} to {size-k-1}th index, this will be the new last node after {k} rotation.
        for(int i=0; i<(size-k-1); i++) {
            curr = curr.next;
        }

        // Fix pointers to complete the rotation 
        // last node's next {last.next} will be the current head node {head}
        last.next = head;
        // {curr.next} will be the new head node
        head = curr.next;
        // {curr} will be the new last node and it's will point to null
        curr.next = null;
        
        return head;
    }
}
