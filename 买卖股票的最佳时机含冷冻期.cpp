class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size() == 0){
            return 0;
        }
        vector<vector<int>> dp(prices.size(),vector<int>(4,0));
        //dp[i][0]:第i天处于买入股票状态(可能是当前天买也可能是之前买了后没操作)
        //dp[i][1]:第i天处于保持卖出状态(两天之前卖出了股票，然后一直没操作)
        //dp[i][2]:第i天处于正好当前卖出股票状态(之前是买入股票状态，今天卖掉股票)
        //dp[i][3]:第i天处于冷冻期状态(前一天刚把股票卖掉，今天就处于冷冻期)
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        for (int i = 1 ; i < prices.size() ; i++){
            dp[i][0] = max(dp[i-1][0],max(dp[i-1][1]-prices[i],dp[i-1][3]-prices[i]));
            dp[i][1] = max(dp[i-1][1],dp[i-1][3]);
            dp[i][2] = dp[i-1][0]+prices[i];
            dp[i][3] = dp[i-1][2];
        }
        return max(dp[prices.size()-1][1],max(dp[prices.size()-1][2],dp[prices.size()-1][3]));
    }
};