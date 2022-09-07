/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 边界条件
        if (root == null || root == p || root == q){
            // 题目给定公共祖先必定存在，因此可以这么写
            return root;
        }
        // 单层逻辑
        // 先序遍历
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null){
            return root;
        }
        if (left != null && right == null){
            return left;
        }
        if (left == null && right != null){
            return right;
        }
        return null;
    }
}