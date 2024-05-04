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
    int firstMin;
    long res = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        firstMin = root.val;
        dfs(root);
        return res < Long.MAX_VALUE ? (int) res : -1;
    }
    public void dfs(TreeNode node) {
        if (node!=null){
            if (firstMin < node.val && node.val<res){
                res = node.val;
            } else if (firstMin == node.val){
                dfs(node.left);
                dfs(node.right);
            }
        }
    }
}