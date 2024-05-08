/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // Counter to keep track of the number of nodes visited
        int[] count = new int[1];
        // Variable to store the result
        int[] result = new int[1];
        // Call the recursive function to perform in-order traversal
        inorder(root, k, count, result);
        // Return the kth smallest element
        return result[0];
    }
    
    // Recursive function to perform in-order traversal and find the kth smallest element
    private void inorder(TreeNode node, int k, int[] count, int[] result) {
        // Base case
        if (node == null)
            return;
        
        // Traverse left subtree
        inorder(node.left, k, count, result);
        
        // Increment the counter for each node visited
        count[0]++;
        
        // If kth element is found, update the result and return
        if (count[0] == k) {
            result[0] = node.val;
            return;
        }
        
        // Traverse right subtree
        inorder(node.right, k, count, result);
    }
}