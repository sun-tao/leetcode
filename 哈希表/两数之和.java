class Solution {
    // public int[] twoSum(int[] nums, int target) {
    //     //纯暴力
    //     for (int i = 0 ; i < nums.length ; i++){
    //         for (int j = i + 1 ; j < nums.length ; j++){
    //             if (nums[i] + nums[j] == target){
    //                 return new int[] {i,j};
    //             }
    //         }
    //     }
    //     return new int[2];
    // }

     public int[] twoSum(int[] nums, int target){
         // HashMap<Integer,Integer> hm = new HashMap<>();
         // for (int i = 0 ; i < nums.length ; i++){
             // if (hm.containsKey(target - nums[i])){
                 // int v = hm.get(target - nums[i]);
                 // return new int[] {v,i};
             // }
             // hm.put(nums[i],i);
         // }
         // return new int[2];
         
         int [] res = new int[2];
         if (nums == null || nums.length == 0){ 
            return res;
         }
         Map<Integer,Integer> map = new HashMap<>();
         for (int i = 0 ; i < nums.length ; i++){
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                res[0] = i;
                res[1] = map.get(temp);
                break;
            }
            map.put(nums[i],i);
         }
         return res;
     }
}