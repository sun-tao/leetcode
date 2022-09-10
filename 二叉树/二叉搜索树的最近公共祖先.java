/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
	// 另有一种更简单的解法，对于二叉搜索树而言不需要自底向上地判断公共祖先
	// 二叉搜索树本身有序，因此只要寻找到第一个值在p和q之间的结点返回即是最近公共祖先
	// 若是遇到了等于p和q的结点也直接返回即可，此时保证该结点是公共祖先，不像上一题可能会被回溯的上面结点替换掉，这边返回的保证是公共祖先。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 边界条件
        if (root == null || root == p || root == q){
            return root;
        }

        //单层逻辑
        //利用二叉搜索树的特性进行遍历二叉树,可以减少走的宽度,遇到当前结点小于或者大于两个
        //p,q两个结点时，可以只遍历一边
        TreeNode right = null;
        TreeNode left = null;
        if (p.val > root.val && q.val > root.val){
            right = lowestCommonAncestor(root.right,p,q);
        }
        else if (p.val < root.val && q.val < root.val){
            left = lowestCommonAncestor(root.left,p,q);
        }
        else if (p.val == root.val || q.val == root.val){
            return root;
        }
        else if (p.val > root.val || p.val < root.val){
            left = lowestCommonAncestor(root.left,p,q);
            right = lowestCommonAncestor(root.right,p,q);
        }
        
        if(left != null && right != null){
            return root;
        }

        else if(left != null && right == null){
            return left;
        }

        else if (left == null && right != null){
            return right;
        }
        return null;
    }
}