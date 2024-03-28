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
        if (head==null || head.next==null)
            return head;
        // pointer
        ListNode current = head;
        while (current.next!=null) {
            if (current.val==current.next.val) {
                current.next=current.next.next;//remove link to the next node
                // create a new link to the node behind the next node
            } else {
                current = current.next; // move pointer to the next node
            }
        }
        return head;
        
    }
}