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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 如果root结点小于low则仅保留其右子树
        // 如果root结点大于high则仅保留其左子树
        if (root == null){
            return root;
        }
        TreeNode left = trimBST(root.left,low,high);
        TreeNode right = trimBST(root.right,low,high);

        if (root.val < low){
            root = right;
        }
        else if (root.val > high){
            root = left;
        }
        else{
            root.left = left;
            root.right = right;
        }
        return root;
    }
}