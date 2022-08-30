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
    private int findMaxValueIndex(int[] nums,int begin,int end){
        // 找数组的最大值的下标,题目保证最大值唯一
        int maxValue = Integer.MIN_VALUE;
        int maxValueIndex = 0;
        for (int i = begin ; i < end ; i++){
            if (nums[i] >= maxValue){
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }
        return maxValueIndex;
    }
    private TreeNode traversal(int[] nums,int begin,int end){
        //out.println("begin=" + begin + " end=" + end);
        if (begin >= end){
            return null;
        }
        int maxValueIndex = findMaxValueIndex(nums,begin,end);
        TreeNode root = new TreeNode(nums[maxValueIndex]);
        // 递归左右子树
        root.left = traversal(nums,begin,maxValueIndex);
        root.right = traversal(nums,maxValueIndex+1,end);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums,0,nums.length);
    }
}