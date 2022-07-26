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
    public ListNode deleteDuplicates(ListNode head) {
        if( head == null ) return null;
        
        ListNode read = head.next, write = head;

        while( read != null ) {
            if( read.val != write.val ) {
                write.next = read;
                write = write.next;
            }
            read = read.next;
        }
        write.next = null;
        
        return head;
    }
}
