class Solution {
    private void rotateHelper(int[] nums,int begin,int end){
        while(begin < end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
        return;
    }
    public void rotate(int[] nums, int k) {
        // 两次反转
        k = k % nums.length;
        rotateHelper(nums,0,nums.length-1);
        rotateHelper(nums,0,k-1);
        rotateHelper(nums,k,nums.length-1);
        return;
    }
}