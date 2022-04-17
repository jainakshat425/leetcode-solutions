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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
        Merge Sort Approach 
        
        if( list1 == null ) {
            return list2;
        }
        if( list2 == null ) {
            return list1;
        }
        
        ListNode p1 = list1, p2 = list2;
        ListNode newHead, p3;
        
        if( p1.val <= p2.val ) {
            newHead = p3 = p1;
            p1 = p1.next;
        } else {
            newHead = p3 = p2;
            p2 = p2.next;
        }
        while( p1 != null && p2 != null ) {
            
            if( p1.val <= p2.val ) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        
        if( p1 != null ) {
            p3.next = p1;
        }
        
        if( p2 != null ) {
            p3.next = p2;
        }
        
        return newHead;
        */
        /* 
        1. Create a dummy node which will point to the head of the new list.
        2. Create a tail node which will point to the last node in the sorted list during sorting
        3. Repeat while one of the pointer {list1 or list2} reaches the end
            - if {list1.val} < {list2.val}, next sorted element will be {list1}
            - else {list2.val} <= {list1.val}, next sorted element will be {list2}
            - Move the {tail} pointer to the next of {tail} node.
        4. If {list1} is not traversed completely, make {list1} next of the tail node.
        5. If {list2} is not traversed completely, make {list2} next of the tail node.
        6. Return {dummy.next} which is the head of new list
        */
        
        // Create a dummy node which will point to the head of the new list.
        ListNode dummy = new ListNode(-1);
        
        // Create a tail node which will point to the last node in the sorted list during sorting
        ListNode tail = dummy;
        
        // Repeat while one of the pointer {list1 or list2} reaches the end
        while( list1 != null && list2 != null ) {
            
            // if {list1.val} < {list2.val}, next sorted element will be {list1}
            if( list1.val < list2.val ) {
                tail.next = list1;
                list1 = list1.next;
            } 
            // else {list2.val} <= {list1.val}, next sorted element will be {list2}
            else {
                tail.next = list2;
                list2 = list2.next;
            }
            
            // Move the {tail} pointer to the next of {tail} node.
            tail = tail.next;
        }
        
        // If {list1} is not traversed completely, make {list1} next of the tail node.
        if( list1 != null ) {
            tail.next = list1;
        }
        // If {list2} is not traversed completely, make {list2} next of the tail node.
        if( list2 != null ) {
            tail.next = list2;
        }
        
        // Return {dummy.next} which is the head of new list
        return dummy.next;
    }
}
