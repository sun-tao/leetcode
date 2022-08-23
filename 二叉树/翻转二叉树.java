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
    public void swapTreeNode(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return;
    }
    public TreeNode invertTree(TreeNode root) {
        // 这题又写复杂了,边界条件没必要一定要是叶子节点，空节点做边界也可以
        // 后序
        // 边界条件
        // if (root == null){
        //     return root;
        // }
        // if (root.left == null && root.right == null){
        //     return root;
        // }
        // //单层逻辑，实现反转结点
        // TreeNode root_left = null;
        // if (root.right != null){
        //    root_left = invertTree(root.right);
        // }
        // TreeNode root_right = null;
        // if (root.left != null){
        //     root_right = invertTree(root.left);
        // }
        // root.left = root_left;
        // root.right = root_right;
        // return root;

        // 前序遍历
        if (root == null){
            return root;
        }
        swapTreeNode(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;  // 这一步在中间没有作用，仅在最后返回结果的时候有用
    }
}