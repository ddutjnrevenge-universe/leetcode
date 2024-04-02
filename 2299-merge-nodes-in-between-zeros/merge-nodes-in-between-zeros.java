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
    public ListNode mergeNodes(ListNode head) {
        ListNode current = head.next;
        ListNode dummy = new ListNode(0);
        ListNode prevZero = dummy;
        while (current !=null && current.next!=null) {
            int sum = 0;
            while (current != null && current.val != 0) {
                sum += current.val;
                current=current.next;
            }
            if (current !=null && current.val==0) {
                prevZero.next = new ListNode(sum);
                prevZero = prevZero.next;
                current = current.next;
            }    
        }
        return dummy.next;
    }
}