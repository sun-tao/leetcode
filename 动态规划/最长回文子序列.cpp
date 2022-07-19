class Solution {
public:
    int longestPalindromeSubseq(string s) {
        //dp[i][j]:以[i,j]为范围的子字符串的最长回文子序列的大小

        vector<vector<int>> dp(s.size(),vector<int>(s.size(),0));
        for (int i = s.size() - 1 ; i >= 0 ; i--){
            for (int j = i ; j < s.size() ; j++){
                if (s[i] == s[j]){
                    if (j - i == 0){
                        dp[i][j] = 1;
                    }
                    else if (j - i == 1){
                        dp[i][j] = 2;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }
                }
                else{
                    //潜台词，j>i
                    dp[i][j] = max(dp[i][j-1],dp[i+1][j]); 
                }
            }
        }
        return dp[0][s.size()-1];
    }
};