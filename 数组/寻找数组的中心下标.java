import static java.lang.System.out;
class Solution {
    public int pivotIndex(int[] nums) {
        // 暴力,O(n^2)
        // int leftSum = 0;
        // int rightSum = 0;
        // for (int i = 0 ; i < nums.length ; i++){
        //     leftSum = 0;
        //     rightSum = 0;
        //     for (int j = 0 ; j < i ; j++){
        //         leftSum += nums[j];
        //     }
        //     for (int j = i+1 ; j < nums.length; j++){
        //         rightSum += nums[j];
        //     }
        //     // out.println("leftSum="+leftSum);
        //     // out.println("rightSum=" + rightSum);
        //     if (leftSum == rightSum){
        //         return i;
        //     }
        // }
        // return -1;

        // O(n)解法,复用了每个数组元素
        if (nums.length == 0){
            return -1;
        }
        int rightSum = 0;
        for (int i = 0 ; i < nums.length; i++){
            rightSum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0 ; i < nums.length ; i++){
            // out.println("leftSum="+leftSum);
            // out.println("rightSum=" + rightSum);
            if (i == 0){
                rightSum -= nums[i];
            }
            else if(i >= 1){
                leftSum += nums[i-1];
                rightSum -= nums[i];
            }
            if (leftSum == rightSum){
                return i;
            }
        }
        return -1;
        
    }
}