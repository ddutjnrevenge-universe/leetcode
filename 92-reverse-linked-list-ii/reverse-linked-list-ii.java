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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head ==null || left == right)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevLeft = dummy;
        ListNode current = head;
        int count =1;
        while (count<left) {
            prevLeft = current;
            current = current.next;
            count++;
        }
        ListNode prev = null;
        ListNode next = head;
        ListNode leftNode = current;
        
        while (count<=right) {
            next =  current.next;
            current.next=prev;
            prev = current;
            current = next;
            count++;
        }
        prevLeft.next=prev;
        leftNode.next=current;
        return dummy.next;
    }
}