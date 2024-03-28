/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        
        // Step 1: Traverse both lists to find their lengths and the last nodes
        ListNode tailA = headA;
        ListNode tailB = headB;
        int lenA = 1;
        int lenB = 1;
        
        while (tailA.next != null) {
            tailA = tailA.next;
            lenA++;
        }
        
        while (tailB.next != null) {
            tailB = tailB.next;
            lenB++;
        }
        
        // Step 2: If the last nodes are different, then the lists don't intersect
        if (tailA != tailB)
            return null;
        
        // Step 3: Calculate the difference in lengths of the two lists
        int diff = Math.abs(lenA - lenB);
        
        // Step 4: Traverse the longer list by the difference in lengths
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        if (lenA > lenB) {
            while (diff > 0) {
                ptrA = ptrA.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                ptrB = ptrB.next;
                diff--;
            }
        }
        
        // Step 5: Traverse both lists simultaneously until we find the intersection or reach the end of both lists
        while (ptrA != ptrB) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        
        // Step 6: If we find an intersection, return that node
        return ptrA;
    }
}