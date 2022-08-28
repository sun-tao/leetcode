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
    List<List<Integer>> result = new ArrayList<>();
    private void traversal(TreeNode root, List<Integer> path, int count){
        if (root.left == null && root.right == null && count == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }

        if (root.left != null){
            count -= root.left.val;
            path.add(root.left.val);
            traversal(root.left,path,count);
            count += root.left.val;
            path.remove(path.size() - 1);
        }
        if (root.right != null){
            count -= root.right.val;
            path.add(root.right.val);
            traversal(root.right,path,count);
            count += root.right.val;
            path.remove(path.size() - 1);
        }
        return;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return result;
        }
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        int count = targetSum - root.val;
        traversal(root,path,count);
        return result;
    }
}