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
 import static java.lang.System.out;
class Solution {
    // 这边采用了先算出总和，再顺序逐步累减，得到各个结点的转换后数值
    // 要进行两趟遍历二叉树，若采用右中左遍历累加，则只需要一趟遍历即可
    int sum = 0;
    private void traversal(TreeNode root){
        if (root == null){
            return;
        }
        traversal(root.left);
        int temp = root.val;
        root.val = sum;
        sum -= temp;
        traversal(root.right);
        return;
    }
    private void calSum(TreeNode root){
        if (root == null){
            return;
        }
        sum += root.val;
        calSum(root.left);
        calSum(root.right);
        return;
    }
    public TreeNode convertBST(TreeNode root) {
        // 中序遍历该二叉搜索树即可，利用二叉搜索树的特性
        calSum(root);
        traversal(root);
        return root;
    }
}