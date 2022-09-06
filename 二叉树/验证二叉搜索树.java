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
    long maxValue = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // 原地判断，不新开空间
        // 利用递归模拟在数组中比较相邻元素大小，判断升序
        // 利用中序遍历二叉树,中序遍历到的结点应该为递增的,即每一个都比前一个大,可以用全局变量保存前一个的值
        if (root == null){
            return true;
        }

        boolean left = isValidBST(root.left);
        if (!left){
            return false;
        }
        if (maxValue < root.val){
            maxValue = root.val;
        }
        else{
            return false;
        }
        boolean right = isValidBST(root.right);
        if (!right){
            return false;
        }
        return true;
    }
}