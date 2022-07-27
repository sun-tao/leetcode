class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right){
            int middle = (left + right) / 2;
            if (nums[middle] == target){
                return middle;
            }
            else if (target > nums[middle]){
                left = middle + 1;
            }
            else{
                right = middle;
            }
        }
        return -1;
    }
}