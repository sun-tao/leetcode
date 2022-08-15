class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 同三数之和原理一样
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i++){
            //去重
            if (i >= 1 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i + 1 ; j < nums.length ; j++){
                //去重
                if (j >= i + 2 && nums[j] == nums[j-1]){
                    continue;
                }
                //System.out.println(j);
                int slow = j + 1;
                int fast = nums.length - 1;
                while(slow < fast){
                    // 当不溢出时，int可以直接赋值给long
                    // 但是一旦溢出就必须要经过 (long)强转
                    long temp = (long) nums[i] + nums[j] + nums[slow] + nums[fast];
                    if (temp < target){
                        slow++;
                    }
                    else if (temp > target){
                        
                        fast--;
                    }
                    else{ // =0
                        result.add(Arrays.asList(nums[i],nums[j],nums[slow],nums[fast]));
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
        }
        return result;
    }
}