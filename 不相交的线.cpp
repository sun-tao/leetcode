class Solution {
private:
    void printDp(const vector<vector<int>>& dp){
        for (int i = 0 ; i < dp.size() ; i++){
            for (int j = 0 ; j < dp[i].size() ; j++){
                cout << dp[i][j] << "," ;
            }
            cout << endl;
        }
    }
public:
    //本题和最长公共子序列所要解决的问题是完全一样的，只是其换了个场景的表述而已，解法完全相同。
    int maxUncrossedLines(vector<int>& nums1, vector<int>& nums2) {
        vector<vector<int>> dp(nums1.size()+1,vector<int>(nums2.size()+1,0));
        for (int i = 1 ; i < dp.size() ; i++){
            for (int j = 1 ; j < dp[i].size(); j++){
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        //printDp(dp);
        return dp[nums1.size()][nums2.size()];
    }
};