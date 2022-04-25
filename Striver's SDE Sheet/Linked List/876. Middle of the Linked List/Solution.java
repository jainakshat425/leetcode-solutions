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
    public ListNode middleNode(ListNode head) {
        // Use two pointers slow and fast to traverse the linked list
        // {slow} will move one node at time and {fast} will move two nodes at a time
        ListNode slow = head, fast = head;
        
        // When {fast} reaches null or fast's next node is null,
        // at that time slow will be pointing to the middle node
        // Keep moving the slow and fast pointer until then
        while( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Return the middle node
        return slow;
    }
}
