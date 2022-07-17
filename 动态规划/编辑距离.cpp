class Solution {
public:
    void printDp(vector<vector<int>>& dp){
        for (int i = 0 ;i < dp.size() ; i++){
            for (int j = 0 ; j < dp[i].size() ; j++){
                cout << dp[i][j] << "," ;
            }
            cout << endl;
        }
    }
    //dp[i][j]:以i为长度的word1，以j为长度的word2，需要编辑的最少距离
    //1.如果word1[i-1] = word2[j-1]，显然dp[i][j] = dp[i-1][j-1]
    //2.如果word1[i-1] != word2[j-1]
    //2.1 删除操作, dp[i-1][j]+1  dp[i][j-1]+1
    //2.2 插入(增加)操作，同上
    //2.3 替换操作, dp[i-1][j-1]+1
    int minDistance(string word1, string word2) {
        vector<vector<int>> dp(word1.size()+1,vector<int>(word2.size()+1,0));
        for (int i = 0 ; i < dp.size() ; i++){
            for (int j = 0 ; j < dp[i].size() ; j++){
                if (j == 0){
                    dp[i][0] = i;
                    continue;
                }
                if (i == 0){
                    dp[0][j] = j;
                    continue;
                }
                if (word1[i-1] == word2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = min(dp[i-1][j],min(dp[i][j-1],dp[i-1][j-1])) + 1;
                }
            }
        }
        //printDp(dp);
        return dp[word1.size()][word2.size()];
    }   
};