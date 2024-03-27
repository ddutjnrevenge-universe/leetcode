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
    public int pairSum(ListNode head) {
        // Reverse the second half of the linked list
        ListNode secondHalf = reverseSecondHalf(head);
        
        // Traverse the linked list and find the maximum twin sum
        int maxSum = Integer.MIN_VALUE;
        ListNode current = head;
        while (current != null && secondHalf != null) {
            int twinSum = current.val + secondHalf.val;
            maxSum = Math.max(maxSum, twinSum);
            current = current.next;
            secondHalf = secondHalf.next;
        }
        
        return maxSum;
    }
    
    // Helper function to reverse the second half of the linked list
    private ListNode reverseSecondHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Find the midpoint of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        
        return prev;
    }
}