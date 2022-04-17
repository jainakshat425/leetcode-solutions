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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum, carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while( l1 != null || l2 != null ) {
            int val1 = 0, val2 = 0;
            
            if( l1 != null ) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if( l2 != null ) {
                val2 = l2.val;
                l2 = l2.next;
            }
            
            sum = carry + val1 + val2;
            carry = sum/10;
            
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

        }
        
        if( carry != 0 ) {
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        
        return dummy.next;
    }
}
