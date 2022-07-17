class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        if (prices.size() == 0){
            return 0;
        }
        vector<vector<int>> dp(prices.size(),vector<int>(2*k+1,0));
        //dp数组初始化
        for (int i = 0 ; i < 2*k+1 ;i++){
            if (i % 2 == 1){
                dp[0][i] = -prices[0];
            }
            else{
                dp[0][i] = 0;
            }
        }

        for (int i = 1 ; i < prices.size() ; i++){
            for (int j = 0 ; j < 2*k+1 ; j++){
                if (j == 0) {
				    dp[i][j] = 0;
				    continue;
			    }
                if (j % 2 == 0){
                    dp[i][j] = max(dp[i-1][j],dp[i-1][j-1]+prices[i]);
                }
                else{
                    dp[i][j] = max(dp[i-1][j],dp[i-1][j-1]-prices[i]);
                }
            }
        }
        return dp[prices.size()-1][2*k];
    }
};