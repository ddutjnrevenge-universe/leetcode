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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
       StringBuilder leaf1 = new StringBuilder();
       StringBuilder leaf2 = new StringBuilder();

        dfs(root1,leaf1);
        dfs(root2,leaf2);

        return leaf1.toString().equals(leaf2.toString());

    }
    private void dfs(TreeNode node, StringBuilder leaf) {
        if (node==null) 
            return;
        if (node.left == null && node.right == null) {
            leaf.append(node.val).append("-");
        }
        dfs(node.left,leaf);
        dfs(node.right,leaf);
    }
}