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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int length = getLength(head);
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        for (int size = 1; size < length; size *= 2) {
            ListNode prev = dummyHead;
            ListNode current = dummyHead.next;
            
            while (current != null) {
                ListNode left = current;
                ListNode right = split(left, size);
                current = split(right, size);
                
                prev = merge(left, right, prev);
            }
        }
        
        return dummyHead.next;
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    
    private ListNode split(ListNode head, int size) {
        if (head == null) {
            return null;
        }
        for (int i = 1; head.next != null && i < size; i++) {
            head = head.next;
        }
        ListNode right = head.next;
        head.next = null;
        return right;
    }
    
    private ListNode merge(ListNode l1, ListNode l2, ListNode prev) {
        ListNode current = prev;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        if (l1 != null) {
            current.next = l1;
        }
        
        if (l2 != null) {
            current.next = l2;
        }
        
        while (current.next != null) {
            current = current.next;
        }
        
        return current;
    }
}