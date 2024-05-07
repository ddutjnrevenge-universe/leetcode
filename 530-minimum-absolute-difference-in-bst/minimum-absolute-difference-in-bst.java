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
    Integer prev;
    int minDiff;

    // Function to perform inorder traversal of the BST and calculate minimum absolute difference
    void inorder(TreeNode root) {
        if (root == null)
            return;

        // Traverse left subtree
        inorder(root.left);

        // Calculate absolute difference with previous node's value
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        }
        prev = root.val;

        // Traverse right subtree
        inorder(root.right);
    }

    // Function to find the minimum absolute difference between the values of any two different nodes in the BST
    public int getMinimumDifference(TreeNode root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;

        // Perform inorder traversal to calculate minimum absolute difference
        inorder(root);

        return minDiff;
    }
}