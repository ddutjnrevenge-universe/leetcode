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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);
        return constructBalancedBST(nodes, 0, nodes.size() - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        inorderTraversal(root.left, nodes);
        nodes.add(root.val);
        inorderTraversal(root.right, nodes);
    }

    private TreeNode constructBalancedBST(List<Integer> nodes, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nodes.get(mid));
        node.left = constructBalancedBST(nodes, start, mid - 1);
        node.right = constructBalancedBST(nodes, mid + 1, end);
        return node;
    }
}

