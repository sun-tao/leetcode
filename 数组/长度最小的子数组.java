class Solution {
    public void printNums(int[] nums){
        for (int i = 0 ; i < nums.length ; i++){
            System.out.println(nums[i] + ",");
        }
    }
    public int minSubArrayLen(int target, int[] nums) {
        //连续子数组，不能改变元素的相对顺序
        int slow = 0;
        int fast = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (;fast < nums.length ; fast++){
            sum += nums[fast];
            if (sum >= target){
                //以当前的slow为开头，fast为结尾的可以，且当前的slow为开头的最短子数组为fast - slow
                while(slow <= fast && sum >= target){
                    result = Math.min(result,fast-slow+1);
                    sum -= nums[slow];
                    slow++;
                }
            }
        }
        if (result == Integer.MAX_VALUE){
            return 0;
        }
        return result;
    }
}