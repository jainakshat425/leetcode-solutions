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
    public ListNode swapPairs(ListNode head) {
        /* 
        1. For each node {head}, if one of the {head} and {head.next} doesn't exist, return {head}
        2. Create a temp node {nextNode} to hold the next node.
        3. Get the next node for current node {head} using recursion (this will swap nodes from the end first).
        4. Next node's next will be {head} and {nextNode} will be the new {head}
        */
        
        // For each node {head}, if one of the {head} and {head.next} doesn't exist, return {head}
        if( head == null || head.next == null ) {
            return head;
        }

        // Create a temp node {nextNode} to hold the next node.
        ListNode nextNode = head.next;
        
        // Get the next node for current node {head} using recursion (this will swap nodes from the end first).
        head.next = swapPairs( head.next.next );;
        
        // Next node's next will be {head} and {nextNode} will be the new {head}
        nextNode.next = head;
        head = nextNode;
        
        return head;
    }
}
