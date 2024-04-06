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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preOrder(root,result);
        return result;
    }
    private void preOrder(TreeNode node, List<Integer> result) {
        if (node==null)
            return;
        result.add(node.val);
        preOrder(node.left,result);   
        preOrder(node.right,result); 
    }   
}