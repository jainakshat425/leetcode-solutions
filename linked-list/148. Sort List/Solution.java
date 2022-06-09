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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode head) {
        if( head == null || head.next == null )
            return head;
        
        ListNode mid = findMid(head);
        ListNode right = mergeSort(mid.next);
        mid.next = null;
        ListNode left = mergeSort(head);
        
        return merge(left, right);
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        
        while( fast.next != null && fast.next.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode pointer = dummy;
        
        while( head1 != null && head2 != null ) {
            if( head2.val < head1.val ) {
                pointer.next = head2;
                head2 = head2.next;
            } else {
                pointer.next = head1;
                head1 = head1.next;
            }
            pointer = pointer.next;
        }
        
        if( head1 != null )
            pointer.next = head1;
        
        if( head2 != null )
            pointer.next = head2;
        
        return dummy.next;
    }
}
