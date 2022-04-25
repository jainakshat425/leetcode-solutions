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
        // Calculate the size of the linked list
        int size = linkedListSize( head );
        
        // Find the middle of the size
        int middle = size/2;
        
        // Move the head pointer to the middle element
        for(int i=0; i<middle; i++) {
            head = head.next;
        }
        
        return head;
    }
    
    private int linkedListSize(ListNode head) {
        int size = 0;
        
        while( head != null ) {
            head = head.next;
            size++;
        }
        
        return size;
    }
}
