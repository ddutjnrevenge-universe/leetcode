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
    int cameras = 0;

    public int minCameraCover(TreeNode root) {
        // Apply DFS starting from the root
        return (dfs(root) == State.UNCOVERED) ? cameras + 1 : cameras;
    }

    // States of a node
    enum State {
        COVERED,
        CAMERA,
        UNCOVERED
    }

    private State dfs(TreeNode node) {
        if (node == null) {
            return State.COVERED;
        }

        State left = dfs(node.left);
        State right = dfs(node.right);

        // If any child needs a camera, place a camera at this node
        if (left == State.UNCOVERED || right == State.UNCOVERED) {
            cameras++;
            return State.CAMERA;
        }

        // If any child has a camera, mark this node as covered
        if (left == State.CAMERA || right == State.CAMERA) {
            return State.COVERED;
        }

        // Otherwise, mark this node as uncovered
        return State.UNCOVERED;
    }
}