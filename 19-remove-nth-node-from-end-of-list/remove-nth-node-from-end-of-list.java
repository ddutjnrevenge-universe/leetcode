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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null || head.next==null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move the fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            if (fast == null)
                return null; // Out of bounds
            fast = fast.next;
        }
        
        // Move both pointers until the fast pointer reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Now slow is pointing to the node just before the node to be removed
        slow.next = slow.next.next;
        
        return dummy.next; // Return the head of the modified list
    }
}