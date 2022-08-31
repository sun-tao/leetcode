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
    private TreeNode traversal(TreeNode root1, TreeNode root2){
        // 边界条件
        if (root1 != null && root2 == null){
            return root1;
        }
        else if (root1 == null && root2 != null){
            return root2;
        }
        else if (root1 == null && root2 == null){
            return root1;
        }
        // 先序遍历
        // 以root1为基准,在其上做修改
        root1.val += root2.val;
        root1.left = traversal(root1.left,root2.left);
        root1.right = traversal(root1.right,root2.right);
        return root1;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return traversal(root1,root2);
    }
}