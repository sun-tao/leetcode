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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return root;
        }
        
        if (root.val == key){
            if (root.right == null && root.left != null){
                // 无右子树
                root = root.left;
            }
            else if (root.right != null && root.left == null){
                //无左子树
                root = root.right;
            }
            else if (root.right == null && root.left == null){
                root = null;
            }
            else{
                // carl哥的解法
                // TreeNode tmp = root.right;
                // while(tmp.left != null){
                //     tmp = tmp.left;
                // }
                // tmp.left = root.left;
                // root = root.right;

                // 自己的解法
                TreeNode tmp = root.left;
                while(tmp.right != null){
                    tmp = tmp.right;
                }
                tmp.right = root.right.left;
                tmp = root.left;
                root = root.right;
                root.left = tmp;
            }
            return root;
        }

        if (root.val < key){
            root.right = deleteNode(root.right,key);
        }
        else if (root.val > key){
            root.left = deleteNode(root.left,key);
        }
        return root;
    }
}