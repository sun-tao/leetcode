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
    private TreeNode traversal(int nums[] , int begin , int end){
        if (begin >= end){
            return null;
        }
        int middle = (begin + end) / 2;
        // 坚持左闭右开原则
        int left_begin = begin;
        int left_end = middle;
        int right_begin = middle + 1;
        int right_end = end;

        TreeNode root = new TreeNode(nums[middle]);
        root.left = traversal(nums,left_begin,left_end);
        root.right = traversal(nums,right_begin,right_end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = traversal(nums,0,nums.length);
        return root;
    }
}