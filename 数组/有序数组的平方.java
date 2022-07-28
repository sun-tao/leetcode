class Solution {
    public int[] sortedSquares(int[] nums) {
        //O(n*logn),没有用到数组有序的特点
        // for (int i = 0 ; i < nums.length ; i++){
        //     nums[i] *= nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;

        //O(n)
        int slow = 0;
        int fast = nums.length - 1;
        int [] result = new int[nums.length];
        int index = result.length - 1;
        while(slow <= fast){
            if (nums[slow] * nums[slow] <= nums[fast] * nums[fast]){
                result[index] = nums[fast] * nums[fast];
                fast--;
            }
            else{
                result[index] = nums[slow] * nums[slow];
                slow++;
            }
            index--;
        }
        return result;
    }
}