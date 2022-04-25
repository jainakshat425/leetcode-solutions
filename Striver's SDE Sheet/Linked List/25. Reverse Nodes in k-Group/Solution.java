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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        // Find the size/total no. of nodes in the linked list
        int size = linkedListSize( head );
        
        // Find the total number of groups which needs to be reversed
        int groups = size / k;
        
        // Points to head of group, for the first first group it will 
        // point to the head, and changes as list gets reversed or 
        // moves to the next group
        ListNode currGroupHead = head;
        
        // Points to the last node of previous group, helps to link the next 
        // group to the previous group after the next group is reversed
        ListNode prevGroupTail = null;

        // Iterate for each group
        for(int i=0; i<groups; i++) {
            
            // Start from the current group's head node
            ListNode curr = currGroupHead;
            
            // To reverse {k} nodes {k-1} links need to be reversed
            for(int j=0; j<(k-1); j++) {
                
                // To reverse the group, keep moving next node to the head
                // of the group
                
                // Next node will be going to be the new head node of the group
                ListNode newHead = curr.next;
                
                // Current node will point to the next node of next 
                curr.next = newHead.next;
                
                // New head node will be previous to current head node 
                // so new head node's next should point to current head node
                newHead.next = currGroupHead;
                
                // Make this {currGroupHead} point to the new head node
                currGroupHead = newHead;                
            }
            
            // If current group is first group, then current group head
            // will be head of the linked list
            if( i == 0 ) {
                head = currGroupHead;
            } else {
                // If current group is not the first group, then previous group's
                // last node should point to current group's head
                prevGroupTail.next = currGroupHead;
            }
            
            // Make {prevGroupTail} point to the last node of current group
            prevGroupTail = curr;
            // Move {currGroupHead} to the head of the next group
            currGroupHead = curr.next;
        }
        
        return head;
    }
    
    private int linkedListSize(ListNode head) {
        int size = 0;
        
        while( head != null ) {
            head = head.next;
            ++size;
        }
        return size;
    }
}
