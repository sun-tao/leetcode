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
    // 本题如果直接想保存前一个结点的int值，则会在第一个结点处卡住
    // 如果让prev_int为INT_MIN，看似可以但实际会遇到溢出问题，abs(0 - INT_MIN) = INT_MIN
    // 因此本题换种角度，直接考虑存储前一个结点，问题迎刃而解
    int result = Integer.MAX_VALUE;  // 最小差值
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return result;
        }
        getMinimumDifference(root.left);  // 左
        if (prev != null){
            int temp = Math.abs(root.val - prev.val);
            result = temp < result ? temp : result;
        }
        prev = root;
        getMinimumDifference(root.right);
        return result;
    }
}