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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null)
            return res;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0.0;
            for (int i = 0; i<size; i++) {
                TreeNode current = queue.poll();
                sum += current.val;
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right!=null)
                    queue.offer(current.right);
            }// else if (current.left!=null && current.right!=null)
                res.add(sum/size);
        }
        return res;
    }
}