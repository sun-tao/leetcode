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
    List<Integer> result = new ArrayList<>();
    List<Integer> nodes = new ArrayList<>();
    public void traversal(TreeNode root){
        if (root == null){
            return;
        }
        traversal(root.left);
        nodes.add(root.val);
        traversal(root.right);
        return;
    }
    public int[] findMode(TreeNode root) {
        // 有一个用例一直过不了？不知道原因
		// 二叉搜索树转数组，再求众数
        traversal(root);
        out.println(nodes);
        int max_count = 0;
        int count = 0;
        for (int i = 0 ; i < nodes.size() - 1 ; i++){
            if (nodes.get(i) == nodes.get(i+1)){
                count++;
            }
            else{
                count = 0;
            }
            if (count > max_count){
                result.removeAll(result);
                result.add(nodes.get(i));
                max_count = count;
            }
            else if (count == max_count){
                result.add(nodes.get(i));
            }
        }
        if (max_count == 0){
            result.add(nodes.get(nodes.size()-1 ));
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}


import static java.lang.System.out;
class Solution {
    // 二叉树上原地进行频率计算
    List<Integer> result = new ArrayList<>();
    TreeNode prev;
    int f = 0; // 当前频率
    int max_f = 0; // 最大频率
    private void traversal(TreeNode root){
        if (root == null){
            return;
        }
        traversal(root.left);
        if (prev != null){
            if (root.val == prev.val){
                f++;
            }
            else{
                f = 0;
            }
        }
        if (f > max_f){
            result.removeAll(result);
            result.add(root.val);
            max_f = f;
        }
        else if (f == max_f){
            result.add(root.val);
        }
        prev = root;
        traversal(root.right);
        return;
    }
    public int[] findMode(TreeNode root) {
        traversal(root);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}