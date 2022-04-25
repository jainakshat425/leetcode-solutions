/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Since {node} will never be the tail/last node
        // Copy the value of next node into the current node
        node.val = node.next.val;
        
        // Delete the next node by making node's next point to the node after the node's next
        node.next = node.next.next;
    }
}
