/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
        Set<ListNode> visited = new HashSet<ListNode>();
        
        ListNode curr = headA;
        
        while( curr != null ) {
            visited.add( curr );
            curr = curr.next;
        }
        
        curr = headB;
        
        while( curr != null ) {
            if( visited.contains( curr ) ) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
        */
        /* 
        1. Calculate size of linked list A {sizeA}
        2. Calculate size of linked list B {sizeB}
        3. In the larger list, move curr pointer to the difference in size of both the linked lists, so that same distance need to be travelled from there for both the linked lists.
        4. Move pointers A {currA} and B {currB} until they both are equal or null.
        */
        int sizeA = 0, sizeB = 0;
        
        ListNode currA = headA, currB = headB;
        
        // Calculate size of linked list A {sizeA}
        while( currA != null ) {
            currA = currA.next;
            sizeA++;
        }        
        
        // Calculate size of linked list B {sizeB}
        while( currB != null ) {
            currB = currB.next;
            sizeB++;
        }
        
        currA = headA;
        currB = headB;
        
        // In the larger list, move curr pointer to the difference in size of both the linked lists, so that same distance need to be travelled from there for both the linked lists.
        if( sizeA > sizeB ) {
            for(int i=0; i<(sizeA-sizeB); i++) {
                currA = currA.next;
            }
        } else if( sizeB > sizeA ) {
            for(int i=0; i<(sizeB-sizeA); i++) {
                currB = currB.next;
            }
        }
        
        // Move pointers A {currA} and B {currB} until they both are equal or null.
        while( currA != currB ) {
            currA = currA.next;
            currB = currB.next;
        }
        
        return currA;
    }
}
