class Solution {
public:
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        //dp[i][j]:确实地在nums1中以i为结尾和在nums2中以j为结尾的最长的公共子数组的长度
        //此子数组必须是严格按照数组顺序连续的
        vector<vector<int>> dp (nums1.size(),vector<int>(nums2.size(),0));
        int result = 0;
        for (int i = 0 ; i < dp.size() ; i++){
            for (int j = 0 ; j < dp[i].size() ; j++){
                if (nums1[i] == nums2[j]){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                        result = result > dp[i][j] ? result : dp[i][j];
                        continue;
                    }
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                result = result > dp[i][j] ? result : dp[i][j];
            }
        }
        return result;
    }
};