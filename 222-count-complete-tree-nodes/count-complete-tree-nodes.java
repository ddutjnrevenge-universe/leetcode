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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        
        if (leftHeight == rightHeight) {
            // If left subtree and right subtree have the same height,
            // then the tree is a full binary tree, and the total number
            // of nodes can be calculated using the formula: 2^height - 1
            return (1 << leftHeight) - 1;
        } else {
            // If leftHeight != rightHeight, then the last level is not fully filled.
            // In this case, recursively count the nodes in the left and right subtrees.
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    
    // Helper method to find the height of the left subtree
    private int leftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
    
    // Helper method to find the height of the right subtree
    private int rightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}