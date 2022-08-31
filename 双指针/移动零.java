class Solution {
    public void moveZeroes(int[] nums) {
        // 双指针
        if (nums.length == 0){
            return;
        }
        int slow = 0;
        int fast = 0;
        for (;fast < nums.length ; fast++){
            if (nums[fast] == 0){
                continue;
            }
            nums[slow] = nums[fast];
            slow++;
        }
        for (;slow < nums.length ;slow++){
            nums[slow] = 0;
        }
        return;
    }
}