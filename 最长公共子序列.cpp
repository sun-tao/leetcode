class Solution {
private:
    void printDp(const vector<vector<int>>& dp){
        for (int i = 0 ; i < dp.size() ; i++){
            for (int j = 0 ; j < dp[i].size() ;j++){
                cout << dp[i][j] << ",";
            }
            cout << endl;
        }
    }
public:
    int longestCommonSubsequence(string text1, string text2) {
        //naive解法，O(n^4)直接超时
        // int result = 0;
        // vector<vector<int>> dp(text1.size(),vector<int>(text2.size(),0));
        // for (int i = 0 ; i < dp.size() ; i++){
        //     for (int j = 0 ; j < dp[i].size() ; j++){
        //         if (text1[i] == text2[j]){
        //             if (i == 0 || j == 0){
        //                 dp[i][j] = 1;
        //                 result = result > dp[i][j] ? result : dp[i][j];
        //                 continue;
        //             }
        //             for (int k = 0 ; k < i ; k++){
        //                 for (int v = 0 ; v < j ;v++){
        //                     dp[i][j] = max(dp[k][v],dp[i][j]);
        //                 }
        //             }
        //             dp[i][j]++;
        //         }
        //         result = result > dp[i][j] ? result : dp[i][j];
        //     }
        // }
        // return result;

        //dp[i][j]:A中以i为长度，B中以j为长度的最长公共子序列
        vector<vector<int>> dp(text1.size()+1,vector<int>(text2.size()+1,0));
        //dp数组初始化,好像没必要
        for (int i = 0 ; i <= text1.size() ; i++){
            dp[i][0] = 0;
        }
        for (int i = 0 ; i <= text2.size() ; i++){
            dp[0][i] = 0;
        }

        for (int i = 1 ; i < dp.size() ; i++){
            for (int j = 1 ; j < dp[i].size() ; j++){
                if (text1[i-1] == text2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        //printDp(dp);
        return dp[text1.size()][text2.size()];   
    }
};