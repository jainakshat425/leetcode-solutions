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
        // Two pointers {curr} and {prev} which will be pointing to the node
        // which needs to be reversed and the node which was last reversed.
        ListNode curr = head, prev = null;
        
		    // When the complete list is reversed, current will be pointing to null 
        while( curr != null ) {
		
            // Backup of current's next node, as current will no longer 
            // point to the next node once it will be reversed.
            ListNode next = curr.next;
            
            // Reverse the current node by making current's next point 
            // to the previous node.
            curr.next = prev;
            
            // Current node will become new previous and next node 
            // will become new current node.
            prev = curr;
            curr = next;
        }
		
	      // Previous will point to the new head node.
        return prev;
    }
}
