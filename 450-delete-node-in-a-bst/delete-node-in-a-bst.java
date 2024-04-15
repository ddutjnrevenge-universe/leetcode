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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null){
            return null;
        }
        if (key<root.val){
            root.left = deleteNode(root.left,key);
        } else if (key>root.val){
            root.right = deleteNode(root.right,key);
        } else {
            if (root.left!=null & root.right!=null){
                TreeNode tmp = root;
                TreeNode rightmost = rightmostNode(tmp.left);
                root.val = rightmost.val;
                root.left = deleteNode(root.left,rightmost.val);
            } else if (root.left!=null) {
                root = root.left;
            } else if (root.right!=null) {
                root = root.right;
            } else{
                root = null;
            }
        }
        return root;
    }
    public TreeNode rightmostNode(TreeNode root){
        if (root.right==null)
            return root;
        else
            return rightmostNode(root.right);
    }
}