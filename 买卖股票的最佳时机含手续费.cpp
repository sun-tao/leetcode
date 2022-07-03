class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        //使用动态规划解法为简单题
        //因为没有复杂的状态，而手续费的问题可以由递推公式帮忙考虑
        if (prices.size() == 0){
            return 0;
        }
        vector<vector<int>> dp(prices.size(),vector<int>(2,0));
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1 ; i < prices.size() ; i++){
            dp[i][0] = max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = max(dp[i-1][1],dp[i-1][0]+prices[i]-fee); //由递推公式来决定到底卖不卖
                                                                 //综合考虑了手续费的问题
        }
        return dp[prices.size()-1][1];
    }
};