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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // easy插入,完全不改动二叉搜索树的原本结构
        // 直接插在最后一层
        // 一路走到底即可
        if (root == null){
            root = new TreeNode(val);
            return root;
        }
        TreeNode cur = root;
        while(cur != null){
            //out.println(cur.val);
            if (cur.val < val){
                if (cur.right != null){
                    cur = cur.right;
                    continue;
                }
                break;
            }
            else{
                if (cur.left != null){
                    cur = cur.left;
                    continue;
                }
                break;
            }
        }
        if (cur.val < val){
            cur.right = new TreeNode(val);
        }
        else {
            cur.left = new TreeNode(val);
        }
        return root;
    }
}

// 对比上面的代码改动了细节，遍历的时候使用一个结点保存每个cur的父结点，这样即使cur走到了null，父结点仍然可以访问，简化了代码
import static java.lang.System.out;
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // easy插入,完全不改动二叉搜索树的原本结构
        // 直接插在最后一层
        // 一路走到底即可
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode parent = null;
        // 采用记录上一结点的方法
        while(cur != null){
            parent = cur;
            if (cur.val < val){
                cur = cur.right;
            }
            else{
                cur = cur.left;
            }
        }
        if (parent.val < val){
            parent.right = new TreeNode(val);
        }
        else{
            parent.left = new TreeNode(val);
        }
        return root;
    }
}   