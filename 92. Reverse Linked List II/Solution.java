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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftPrev = null, leftNode = null;
        boolean leftIsHead = left == 1;
        
        if( !leftIsHead ) {
            leftPrev = head;
            for(int pos=1; pos<left-1 && leftPrev != null; pos++)
                leftPrev = leftPrev.next;
        }
        
        ListNode curr = leftNode = (leftIsHead ? head : leftPrev.next);
        
        for(int pos=left; pos<right && curr != null; pos++) {
            ListNode newLeft = curr.next;
            curr.next = newLeft.next;
            newLeft.next = leftNode;
            leftNode = newLeft;
        }
        
        if( !leftIsHead )
            leftPrev.next = leftNode;
        
        return leftIsHead ? leftNode : head;
    }
}
