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
    List<Integer> result = new ArrayList<>();
    // 递归法
    // private void traversal(TreeNode root){
    //     if (root == null){
    //         return;
    //     }
    //     result.add(root.val);
    //     traversal(root.left);
    //     traversal(root.right);
    // }
    // public List<Integer> preorderTraversal(TreeNode root) {
    //    traversal(root);
    //    return result;
    // }

    // 迭代法前序遍历
	// 使用辅助栈来实现迭代法前序遍历
    public List<Integer> preorderTraversal(TreeNode root){
        Deque<TreeNode> st = new ArrayDeque<>();
        if (root == null){
            return result;
        }
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            result.add(node.val);
            if (node.right != null){
                st.push(node.right);
            }
            if (node.left != null){
                st.push(node.left);
            }
        }
        return result;
    }    
}