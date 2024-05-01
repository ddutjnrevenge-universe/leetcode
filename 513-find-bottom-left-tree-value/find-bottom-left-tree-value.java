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
    // public int findBottomLeftValue(TreeNode root) {
    //     if (root==null)
    //         return -1;
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     int leftmost = -1;

    //     while (!queue.isEmpty()){
    //         int size = queue.size();
    //         leftmost = queue.peek().val;
    //         for (int i=0; i<size; i++) {
    //             TreeNode node = queue.poll();
    //             if (node.left!=null) queue.offer(node.left);
    //             if (node.right!=null) queue.offer(node.right);
    //         }
    //     }
    //     return leftmost;
    // }
    int leftmostValue;
    int maxDepth;

    public int findBottomLeftValue(TreeNode root) {
        leftmostValue = -1;
        maxDepth = -1;
        findBottomLeftValueHelper(root, 0);
        return leftmostValue;
    }

    private void findBottomLeftValueHelper(TreeNode node, int depth) {
        if (node == null) return;

        // Update leftmost value and max depth if necessary
        if (depth > maxDepth) {
            leftmostValue = node.val;
            maxDepth = depth;
        }

        // Recur for left and right subtrees
        findBottomLeftValueHelper(node.left, depth + 1);
        findBottomLeftValueHelper(node.right, depth + 1);
    }
}