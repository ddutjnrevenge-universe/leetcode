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
    private int currentVal;
    private int currentCount;
    private int maxCount;
    private int modeCount;
    private int[] modes;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        currentVal = root.val;
        currentCount = 0;
        maxCount = 0;
        modeCount = 0;

        // Count the modes and mode count
        countModes(root);

        // Initialize the modes array
        modes = new int[modeCount];

        // Traverse again to populate the modes array
        currentCount = 0;
        modeCount = 0;
        populateModes(root);

        return modes;
    }

    private void countModes(TreeNode node) {
        if (node == null) return;

        countModes(node.left);

        if (node.val == currentVal) {
            currentCount++;
        } else {
            currentVal = node.val;
            currentCount = 1;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            modeCount = 1;
        } else if (currentCount == maxCount) {
            modeCount++;
        }

        countModes(node.right);
    }

    private void populateModes(TreeNode node) {
        if (node == null) return;

        populateModes(node.left);

        if (node.val == currentVal) {
            currentCount++;
        } else {
            currentVal = node.val;
            currentCount = 1;
        }

        if (currentCount == maxCount) {
            modes[modeCount++] = node.val;
        }

        populateModes(node.right);
    }
}