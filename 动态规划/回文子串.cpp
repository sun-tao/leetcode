class Solution {
public:
    int countSubstrings(string s) {
         //dp[i][j]:以下标i为起始点，j为终止点的子字符串是否是回文子串
         // i <= j
         int result = 0;
         vector<vector<bool>> dp(s.size(),vector<bool>(s.size(),false));
         for (int i = dp.size() - 1 ; i >= 0 ; i--){
             for (int j = i ; j < dp[i].size() ; j++){
                 if (s[i] != s[j]){
                     dp[i][j] = false;
                 }
                 else{
                     if (j - i == 0 || j - i == 1){
                         dp[i][j] = true;
                         result++;
                     }
                     else{
                         dp[i][j] = dp[i+1][j-1];
                         result = dp[i][j] == true ? result + 1 : result;
                     }
                 }
             }
         }
         return result;
    }
};