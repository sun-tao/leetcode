class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3){
            return false;
        }
        // O(n)的解法，两趟遍历数组
        // 模拟题
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0 ; i < arr.length ; i++){
            if (arr[i] > maxValue){
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        if (maxIndex == 0 || maxIndex == arr.length - 1){
            return false;
        }
        int j = 1;
        while(j <= maxIndex){
            if (arr[j] <= arr[j-1]){
                return false;
            }
            j++;
        }
        while(j < arr.length){
            if (arr[j] >= arr[j-1]){
                return false;
            }
            j++;
        }
        return true;
		
		
		//双指针解法
        //只需一趟遍历
        if (arr.length < 3){
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        // 右移动left指针
        while(left < arr.length - 1 && arr[left] < arr[left+1]) left++;
        while(right > 0 && arr[right] < arr[right-1]) right--;
        if (left == right && left != 0 && right != arr.length - 1){
            return true;
        }
        return false;
    }
}