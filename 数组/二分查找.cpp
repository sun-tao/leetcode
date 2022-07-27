class Solution {
public:
    int search(vector<int>& nums, int target) {
        //坚持左闭右开原则
        int left = 0;
        int right = nums.size();
        while(left < right){
            int middle = (left + right) / 2;
            if (nums[middle] == target){
                return middle;
            }
            else if (target > nums[middle]){
                left = middle + 1;
            }
            else{
                right = middle;
            } 
        }
        return -1;
    }
};