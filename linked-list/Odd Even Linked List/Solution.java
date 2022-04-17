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
    public ListNode oddEvenList(ListNode head) {
        /* 
        1. Create pointer {evenHead} pointing to the first even node.
        2. While current {even} node and next odd node {even.next} is not null
            - Point {odd.next} to the next odd node {even.next}
            - Set pointer {odd} to the next odd node {odd.next}
            - Point {even.next} to the next even node {odd.next}
            - Set pointer {even} to the next even node {even.next}
        3. Make last node of odd list {odd} point to the head of even list {evenHead}
        */
        if( head == null )  {
            return null;
        }
        // Create pointer {evenHead} pointing to the first even node.
        ListNode evenHead = head.next;
        
        ListNode odd = head, even = evenHead;
        
        // While current {even} node and next odd node {even.next} is not null
        while( even != null && even.next != null ) {
            // Point {odd.next} to the next odd node {even.next}
            odd.next = even.next;
            // Set pointer {odd} to the next odd node {odd.next}
            odd = odd.next;
            
            // Point {even.next} to the next even node {odd.next}
            even.next = odd.next;
            // Set pointer {even} to the next even node {even.next}
            even = even.next;
        }
        
        // Make last node of odd list {odd} point to the head of even list {evenHead}
        odd.next = evenHead;
        return head;
    }
}
