class Solution {
public:
    //uint64_t是什么类型，为什么用int定义会出错，而用uint64_t虽然足够大，但是返回的仍然只能是int，为什么可以。
    //中间有比最后结果更大的数字出现吗？
    int numDistinct(string s, string t) {
        //dp[i][j]:长度为i的s，长度为j的t，在它们的条件下，最多的t的出现个数
        vector<vector<uint64_t>> dp(s.size()+1,vector<uint64_t>(t.size()+1,0));
        dp[0][0] = 1;
        for (int i = 1 ; i < dp.size() ; i++){
            dp[i][0] = 1;
        }
        for (int j = 1 ; j < dp[0].size() ;j++){
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.size() ; i++){
            for (int j = 1 ; j < dp[i].size() ; j++){
                if (s[i-1] == t[j-1]){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.size()][t.size()];
    }
};