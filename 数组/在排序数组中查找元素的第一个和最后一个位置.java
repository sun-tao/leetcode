import static  java.lang.System.out;
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // O(n),且完全不利用数组有序的性质
        // int begin = Integer.MAX_VALUE;
        // int end = Integer.MIN_VALUE;
        // for (int i = 0 ; i < nums.length ; i++){
        //     if (nums[i] == target){
        //         begin = i > begin ? begin : i;
        //         end = i < end ? end : i;
        //     }
        // }
        // int[] result = new int[2];
        // result[0] = begin == Integer.MAX_VALUE ? -1 : begin;
        // result[1] = end == Integer.MIN_VALUE ? -1 : end;
        // return result;

        // 先二分法找到目标值，再向两边扩散
        // int left = 0;
        // int right = nums.length;
        // int index = -1;
        // while(left < right){
        //     int middle = (left + right) / 2;
        //     if (nums[middle] > target){
        //         right = middle;
        //     }
        //     else if (nums[middle] < target){
        //         left = middle + 1;
        //     }
        //     else {
        //         index = middle;
        //         break;
        //     }
        // }
        // if (index == -1){
        //     return new int[]{-1,-1};
        // }
        // int index_copy = index;
        // int begin = 0;
        // int end = 0;
        // while(index >= 0 && nums[index] == target){
        //     begin = index;
        //     index--;
        // }
        // while(index_copy < nums.length && nums[index_copy] == target){
        //     end = index_copy;
        //     index_copy++;
        // }
        // return new int[]{begin,end};

        // 两次二分法，取左右边界,复杂度O(logn)
        
        int leftBoarder = getLeftBoarder(nums,target);
        int rightBoarder =  getRightBoarder(nums,target);
        if (leftBoarder == -2 || rightBoarder == -2){
            return new int[]{-1,-1};
        }
        if (rightBoarder - leftBoarder <= 1){
            return new int[]{-1,-1};
        }
        return new int[]{leftBoarder+1,rightBoarder-1};
    }
    
    private int getRightBoarder(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        int rightBoarder = -2;
        while(left < right){
            out.println("left=" + left);
            int middle = (left + right) / 2;
            if (target >= nums[middle]){
                left = middle + 1;
                rightBoarder = left;
            }
            else{
                right = middle;
            }
        } 
        return rightBoarder;
    }
    private int getLeftBoarder(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        int leftBoarder = -2;
        while(left < right){
            int middle = (left + right) / 2;
            if (target <= nums[middle]){
                right = middle;
                leftBoarder = right - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return leftBoarder;
    }
}