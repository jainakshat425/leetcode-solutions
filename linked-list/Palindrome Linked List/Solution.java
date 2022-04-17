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
    public boolean isPalindrome(ListNode head) {
        /* 
        int size = 0;
        ListNode curr = head;
        
        while( curr != null ) {
            curr = curr.next;
            size++;
        }
        
        int halfSize = size/2;
        curr = head;
            
        for(int i=0; i<halfSize-1; i++) {
            ListNode newHead = curr.next;
            curr.next = newHead.next;
            newHead.next = head;
            head = newHead;
        }
        
        int secondPointerIndex = size%2 == 0 ? halfSize : halfSize + 1;
        ListNode second = head;
        
        for(int i=0; i<secondPointerIndex; i++) {
            second = second.next;
        }
        
        curr = head;
        
        while( second != null ) {
            if( curr.val != second.val ) {
                return false;
            }
            curr = curr.next;
            second = second.next;
        }
        
        return true;
        */
        
        /* 
        Approach - Divide the list into two half, reverse the second half, check for equality, reverse the second half again
        1. Find the last node of first half {firstHalfEnd}.
        2. Reverse the nodes after first half {firstHalfEnd.next} and store the head of the second half in {secondHalfHead}
        3. Move through each half and check if corresponding node values are equal.
            - If not equal, given list is not a palindrome, break the loop
        4. Reverse the second again to retain the original list.
        */
        
        // Find the last node of first half {firstHalfEnd}.
        ListNode firstHalfEnd = getFirstHalfEnd(head);
        // Reverse the nodes after first half {firstHalfEnd.next} and store the head of the second half in {secondHalfHead}
        ListNode secondHalfHead = reverseList(firstHalfEnd.next);
        
        // 1 2 1 2
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        Boolean result = true;
        
        // Move through each half and check if corresponding node values are equal.
        while( p2 != null ) {
            
            // If not equal, given list is not a palindrome, break the loop
            if( p1.val != p2.val ) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        
        // Reverse the second again to retain the original list.
        firstHalfEnd.next = reverseList(secondHalfHead);
        return result;
    }
    
    public ListNode getFirstHalfEnd(ListNode head) {
        ListNode slow = head, fast = head;
        
        while( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        
        while( curr != null ) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
