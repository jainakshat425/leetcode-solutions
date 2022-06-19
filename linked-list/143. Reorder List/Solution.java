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
    public void reorderList(ListNode head) {
        if( head == null )
            return;
        
        ListNode mid = findMid(head);
        ListNode head2 = reverse(mid.next);
        
        ListNode curr1 = head;
        ListNode curr2 = head2;
        
        while( curr2 != null ) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            
            curr1.next = curr2;
            curr2.next = next1;
            curr1 = next1;
            curr2 = next2;
        }
        curr1.next = null;
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        
        while( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;
        
        while( curr != null ) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = next;
        }
        return prev;
    }
}
/* 
class Solution {
    public void reorderList(ListNode head) {
        if( head == null )
            return;
        
        Stack<ListNode> stack = new Stack();
        ListNode mid = findMid(head);
        ListNode curr = mid.next;
        
        while( curr != null ) {
            stack.push(curr);
            curr = curr.next;
        }
        
        curr = head;
        
        while( !stack.isEmpty() ) {
            ListNode next = curr.next;
            
            curr.next = stack.pop();
            curr.next.next = next;
            curr = next;
        }
        curr.next = null;
    }
    
    public ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        
        while( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
*/
