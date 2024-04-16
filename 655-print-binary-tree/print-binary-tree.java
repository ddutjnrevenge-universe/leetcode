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
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int rows = height;
        int cols = (int) Math.pow(2,height)-1;
        List<List<String>> res = new ArrayList<>();
        for (int i=0; i<rows;i++) {
            List<String> row = new ArrayList<>();
            for (int j=0; j<cols;j++) {
                row.add("");
            }
            res.add(row);
        }
        fillMatrix(root,res,0,0,cols-1);

        return res;
    }
    private int getHeight(TreeNode node) {
        if (node==null) 
            return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
    private void fillMatrix(TreeNode node, List<List<String>> res, int row, int start, int end){
        if (node==null)
            return;
        int mid = (start+end)/2;
        res.get(row).set(mid,Integer.toString(node.val));

        fillMatrix(node.left, res, row+1,start,mid-1);
        fillMatrix(node.right, res, row+1, mid+1, end);
    }
}