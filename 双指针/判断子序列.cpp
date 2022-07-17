class Solution {
public:
    bool isSubsequence(string s, string t) {
        //双指针
        int s_pointer = 0;
        int t_pointer = 0;
        while(s_pointer < s.size() && t_pointer < t.size()){
            if (s[s_pointer] == t[t_pointer]){
                s_pointer++;
            }
            t_pointer++;
        }
        if (s_pointer == s.size()){
            return true;
        }
        return false;
    }
};

class Solution {
public:
    bool isSubsequence(string s, string t) {
        //动态规划
        //dp[i][j]:s中长度为i，t中长度为j的字符串的最长相等子序列(下标为i-1,t-1)
        //深入分析一下，本题中s的长度一定小于t，因此在递推的时候，只需要对t进行删减(即dp[i][j]=dp[i][j-1]),而不需要对s删减，因为s中的所有元素都需要用到。
        //如果完全按照dp[i][j]本身的定义来说，本题的递推应该为dp[i][j] = max(dp[i][j-1],dp[i-1][j])。但是考虑到本题的背景，因此只需要对t删减即可。
        vector<vector<int>> dp(s.size()+1,vector<int>(t.size()+1,0));
        for (int i = 1 ; i < dp.size() ;i++){
            for (int j = 1 ; j < dp[i].size() ; j++){
                if (s[i-1] == t[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        // cout << dp[s.size()][t.size()] << endl;
        if (dp[s.size()][t.size()] == s.size()){
            return true;
        }
        return false; 
    }
};