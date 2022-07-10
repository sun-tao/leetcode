class Solution {
public:
    //动态规划
    //dp[i]:以i为结尾的最大连续子数组的和
    int maxSubArray(vector<int>& nums) {
        if (nums.size() == 0){
            return 0;
        }
        vector<int> dp (nums.size(),0);
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1 ; i < nums.size() ;i++){
            dp[i] = max(dp[i-1]+nums[i],nums[i]);
            result = result > dp[i] ? result : dp[i];
        }
        return result;
    }
};

        
class Solution {
public:
    //贪心
    int maxSubArray(vector<int>& nums) {
         int result = INT_MIN;
         int sum = 0;
         for (int i = 0 ; i < nums.size() ; i++){
             sum += nums[i];
             result = result > sum ? result : sum;
             if (sum <= 0){
                 sum = 0;
             }
         }
         return result;
    }
};