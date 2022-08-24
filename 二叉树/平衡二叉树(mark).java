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
    private int traversal(TreeNode root){
        // 返回值为每个结点的高度
		// 利用返回值的具体数值来判断其子结点是否是平衡的，以及判断本层是否平衡。
		// 如果不为-1则子结点平衡，然后再利用具体数值来计算本层是否平衡
        if (root == null){
            return 0;
        }

        int leftHeight = traversal(root.left);
        if (leftHeight == -1){
            return -1;
        }
        int rightHeight = traversal(root.right);
        if (rightHeight == -1){
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight) + 1;

    }
    public boolean isBalanced(TreeNode root) {
        // 用int的返回值来表征是不是平衡，如果为-1则不是平衡
        int result = traversal(root);
        if (result == -1){
            return false;
        }
        return true;
    }
}