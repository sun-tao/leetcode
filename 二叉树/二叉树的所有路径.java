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
    List<String> result = new ArrayList<>();
    private void traversal(TreeNode root , StringBuffer sb){
        // 边界条件为遇到叶子节点
        // 这题写烦就烦在试图直接在StringBuffer上构造结果，而Java中StringBuffer操作繁琐
        // 如果能在list上操作结果的数值，最终用数值拼接结果会简单很多
        if (root.left == null && root.right ==null){
            StringBuffer temp = new StringBuffer();
            sb.append(root.val);
            temp.append(root.val);
            int len = temp.length();
            result.add(sb.toString());
            sb.delete(sb.length() - len , sb.length());
            return;
        }
        if (root.left != null){
            StringBuffer temp = new StringBuffer();
            temp.append(root.val);
            temp.append("->");
            int len = temp.length();
            sb.append(root.val);
            sb.append("->");
            //递归
            traversal(root.left,sb);
            sb.delete(sb.length() - len, sb.length()); // 删除
        }
        
        if (root.right != null){
            StringBuffer temp = new StringBuffer();
            temp.append(root.val);
            temp.append("->");
            int len = temp.length();
            sb.append(root.val);
            sb.append("->");
            //递归
            traversal(root.right,sb);
            sb.delete(sb.length() - len, sb.length()); // 删除
        }
        return;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return result;
        }
        StringBuffer sb = new StringBuffer();
        traversal(root,sb);
        return result;
    }
}