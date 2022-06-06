/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 8:13
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        
        if( n == 0 )
            return null;
        
        return mergeSort(0, n-1, lists);
    }
    
    private ListNode mergeSort(int start, int end, ListNode[] lists) {
        if( start == end ) 
            return lists[start];
        
        if( start == end-1 ) 
            return merge(lists[start], lists[end]);
        
        int mid = start + (end-start)/2;
        
        ListNode head1 = mergeSort(start, mid, lists);
        ListNode head2 = mergeSort(mid+1, end, lists);
        
        return merge(head1, head2);
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
