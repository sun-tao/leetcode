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
    private boolean traversal(TreeNode root,int targetSum,int path){
        // 需要保证root不为null
        path += root.val;
        if (root.left == null && root.right == null){
            // path += root.val;
            if (path == targetSum){
                return true;
            }
            return false;
        }
        if (root.left != null){
            //path += root.val; // 放前面
            if (traversal(root.left,targetSum,path)){
                return true;
            };
            //path -= root.val;  // 放后面应该也可以
        }

        if (root.right != null){
            //path += root.val;
            if (traversal(root.right,targetSum,path)){
                return true;
            }
            //path -= root.val;
        }
        path -= root.val;
        
        return false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
           return false;
        }
        return traversal(root,targetSum,0);
    }
}