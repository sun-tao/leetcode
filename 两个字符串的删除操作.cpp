class Solution {
public:
    int minDistance(string word1, string word2) {
        // 问题转化为找最长的相等子序列
        //dp[i][j]:以i为长度的word1,以j为长度的word2,最长相等子序列的长度
        vector<vector<int>> dp(word1.size()+1,vector<int>(word2.size()+1,0));
        for (int i = 1; i < dp.size() ; i++){
            for (int j = 1 ; j < dp[i].size() ; j++){
                if (word1[i-1] == word2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
                }
            } 
        }
        int len = dp[word1.size()][word2.size()]; //word1和word2最长相等子序列长度
        //cout << "len=" << len << endl;
        int result = word1.size() + word2.size() - 2 * len;
        return result;
    }
};