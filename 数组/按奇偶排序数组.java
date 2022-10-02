class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        //暴力时间O(n)，空间O(n)
        int size = nums.length;
        int[] odd = new int[size/2];
        int[] even = new int[size/2];
        int odd_idx = 0;
        int even_idx = 0;
        for (int i = 0 ; i < size ; i++){
            if (nums[i] % 2 == 0){
                even[even_idx++] = nums[i];
            }
            else{
                odd[odd_idx++] = nums[i];
            }
        }
        int[] result = new int[size];
        for (int i = 0 ; i < size ; i++){
            if (i % 2 == 0){
                result[i] = even[i/2];
            }
            else {
                result[i] = odd[(i-1)/2];
            }
        }
        return result;
    }
}