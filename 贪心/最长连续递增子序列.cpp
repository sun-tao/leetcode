class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        //动态规划
        if (nums.size() == 0){ 
            return 0;
        }
        if (nums.size() == 1){
            return 1;
        }
        vector<int> dp(nums.size() , 1);
        int result = 0;
        for (int i = 1 ; i < nums.size() ; i++){
            if (nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            result = result > dp[i] ? result : dp[i];
        }
        return result;
    }
};


class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        //贪心
        if (nums.size() == 0){
            return 0;
        }

        int len = 1;
        int result = 1;
        for (int i = 1 ; i < nums.size(); i++){
            if (nums[i] > nums[i-1]){
                len++;
            }
            else{
                len = 1;
            }
            result = result > len ? result : len;
        }
        return result;
    }
};