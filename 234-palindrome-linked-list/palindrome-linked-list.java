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
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        
        // Store elements of the linked list in an array
        int[] arr = new int[length];
        current = head;
        int i = 0;
        while (current != null) {
            arr[i++] = current.val;
            current = current.next;
        }
        
        // Use two pointers to check for palindrome
        int left = 0, right = length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}