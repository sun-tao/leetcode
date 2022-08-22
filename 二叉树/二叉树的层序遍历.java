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
	// 使用辅助队列来实现层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> que = new ArrayDeque<>();
        if (root == null){
            return result ;
        }
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            int cnt = 0;
            List<Integer> temp = new ArrayList<>();
            while(cnt < size){
                TreeNode node = que.poll();
                temp.add(node.val);
                if (node.left != null){
                    que.offer(node.left);
                }
                if (node.right != null){
                    que.offer(node.right);
                }
                cnt++;
            }
            result.add(temp);
        }
        return result;
    }
}