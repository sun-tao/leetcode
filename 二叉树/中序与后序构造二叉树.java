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
    private TreeNode traversal(int[] inorder,int[] postorder,
                               int inorderbegin, int inorderend,
                               int postorderbegin, int postorderend){
        // 边界条件
        // 坚持左闭右开原则
        if (inorderbegin >= inorderend){
            return null;
        }               
        int navigation = postorder[postorderend-1];
        int inorderIndex = 0;
        for (; inorderIndex < inorder.length; inorderIndex++){
            if (inorder[inorderIndex] == navigation){
                break;
            }
        }
        int len = inorderIndex - inorderbegin;
        int inorderleftBegin = inorderbegin;
        int inorderleftEnd = inorderIndex;
        int inorderrightBegin = inorderIndex + 1;
        int inorderrightEnd = inorderend;

        int postorderleftBegin = postorderbegin;
        int postorderleftEnd = postorderbegin + len;
        int postorderrightBegin = postorderbegin + len;
        int postorderrightEnd = postorderend - 1;
        // 当前的根节点
        TreeNode root = new TreeNode(navigation);
        root.left = traversal(inorder,postorder,inorderleftBegin,inorderleftEnd,postorderleftBegin,postorderleftEnd);
        root.right = traversal(inorder,postorder,inorderrightBegin,inorderrightEnd,postorderrightBegin,postorderrightEnd);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return traversal(inorder,postorder,0,inorder.length,0,postorder.length);
    }
}