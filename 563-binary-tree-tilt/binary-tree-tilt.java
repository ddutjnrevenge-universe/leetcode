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
    int tiltSum = 0;
    public int findTilt(TreeNode root) {
        postOrderTraversal(root);
        return tiltSum;
    }
    private int postOrderTraversal(TreeNode node){
        if (node==null) return 0;
        // if (node.left==null && node.right==null) return 0;
        int leftSum = postOrderTraversal(node.left);
        int rightSum = postOrderTraversal(node.right);
        
        // Calculate tilt for the current node and update tiltSum
        tiltSum += Math.abs(leftSum - rightSum);
        
        // Return the sum of values in the current subtree
        return leftSum + rightSum + node.val;
    }
}