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
    int xDepth=-1, yDepth=-1;
    TreeNode xParent = null, yParent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x,y,0);
        return xDepth == yDepth  && xParent!=yParent;
        
    }
    public void dfs(TreeNode root, TreeNode parent, 
    int x, int y, int depth){
        if (root==null){
            return;
        }
        if (x==root.val){
            xParent = parent;
            xDepth = depth;
        } else if (y==root.val){
            yParent = parent;
            yDepth = depth;
        } else {
            dfs(root.left, root, x, y, depth +1);
            dfs(root.right, root, x, y, depth +1);
        }
    }
}