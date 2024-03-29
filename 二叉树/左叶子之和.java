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
    int result = 0;
    private void traversal(TreeNode root ,boolean isLeft){
        if (root.left == null && root.right == null){
            if (isLeft){
                result += root.val;
            }
            return;
        }
        if (root.left != null){
            traversal(root.left,true);
        }
        if (root.right != null){
            traversal(root.right,false);
        }
        return;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return result;
        }
        traversal(root,false);
        return result;
    }
}