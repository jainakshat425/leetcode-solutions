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
        // Points to the head of the sum linked list
        ListNode dummy = new ListNode(-1);
        // Points to the last number in sum
        ListNode curr = dummy;
        
        // Sum of current node values from l1 and l2 and carry from the previous sum
        int sum, carry = 0;
        
        // Repeat until both of the numbers are completely summed
        while( l1 != null || l2 != null ) {
            
            // Get values from current nodes under l1 and l2
            // and move them to the next nodes
            int val1 = 0, val2 = 0;
            
            if( l1 != null ) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if( l2 != null ) {
                val2 = l2.val;
                l2 = l2.next;
            }
            
            // Calculate sum from l1 and l2 node values and carry from the previous sum.
            sum = carry + val1 + val2;
            
            // Get carry from current sum
            carry = sum/10;
            
            // If current sum is greater than 9, new node will only contain only the 
            // least significant digit (lsd) and remaining will be counted as carry
            int lsd = sum % 10;
            
            // Append the current sum to the sum linked list and move current to the
            // appended node
            curr.next = new ListNode( lsd );
            curr = curr.next;
        }
        
        // If carry from last sum is not 0, append the carry to the sum linked list
        if( carry != 0 ) {
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        
        // Return the head of the linked list
        return dummy.next;
    }
}
