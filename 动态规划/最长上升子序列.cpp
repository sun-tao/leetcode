class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> dp(nums.size(),1);
        //dp[i]:以i为结尾的最长子序列长度
        int result = 1;
        for (int i = 0 ; i < nums.size(); i++){
            for (int j = 0 ; j < i ; j++){
                if (nums[i] > nums[j]){
                    dp[i] = max(dp[i],dp[j]+1);
                }
                //时刻保存最长的长度，因为最终的结果子序列并不一定是以最后一个元素
                //作为结尾的。而是最长即可
                result = result > dp[i] ? result : dp[i];
            }
        }
        return result;
    }
};