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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
    
        k %= length; // Reduce k to a value less than length of the list

        for (int i = 0; i < k; i++) {
            ListNode prev = head;
            while (prev.next.next != null) {
                prev = prev.next;
            }
            ListNode tail = prev.next;
            tail.next = head;
            prev.next = null;
            head = tail;
        }
        return head;
    }
}