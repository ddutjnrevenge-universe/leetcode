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
        if (head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next!=null){
            if (current.next.next!=null && current.next.val==current.next.next.val) {
                int val = current.next.val;
                while (current.next!=null && current.next.val==val) {
                    current.next=current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }
}