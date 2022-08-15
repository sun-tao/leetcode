class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //双指针解法
        List<List<Integer>> result = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i++){
            // 第一个元素去重
            if (i >= 1 && nums[i] == nums[i-1]){
                continue;
            }
            //开启双指针遍历，针对第一个元素，查找使得三数之和为0的剩余两元素
            int slow = i + 1;
            int fast = nums.length - 1;
            while(slow < fast){
                if (nums[slow] + nums[fast] < 0 - nums[i]){ //可能会溢出这边
                    slow++;
                }
                else if (nums[slow] + nums[fast] > 0 - nums[i]){
                    fast--;
                }
                else{
                    // 第2,3个元素去重，必须在遍历的时候就直接去重，否则如果在满足条件收获结果的时候
                    // 进行去重就需要遍历结果集，那就复杂了
                    // List<Integer> temp = new ArrayList<>();
                    // temp.add(nums[i]);
                    // temp.add(nums[slow]);
                    // temp.add(nums[fast]);
                    // result.add(temp);
                    List<Integer> temp = Arrays.asList(nums[i],nums[slow],nums[fast]);
                    result.add(temp);
                    slow++;
                    fast--;
                    while(slow < fast && nums[slow] == nums[slow-1]){
                        slow++;
                    } 
                    while(slow < fast && nums[fast] == nums[fast+1]){
                        fast--;
                    }
                }
            }
        }
        return result;
    }
}