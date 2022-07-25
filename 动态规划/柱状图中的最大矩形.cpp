class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
    //动态规划
    //本题的动规思路复杂
    //dp1[i]:以i为中心，左边第一个比i的高度小的元素的下标
    //dp2[i]:以i为中心，右边第一个比i的高度小的元素的下标
    int result = 0;
    vector<int> dp1 (heights.size(),0);
    vector<int> dp2 (heights.size(),0);
    dp1[0] = -1;
    //从左向右
    for (int i = 1 ; i < dp1.size() ; i++){
        int t = i - 1;
        while(t >= 0 && heights[t] >= heights[i]){
            t = dp1[t];
        }
        dp1[i] = t;
    }
    dp2[dp2.size()-1] = dp2.size();
    //从右向左
    for (int i = dp2.size() - 2; i >= 0 ; i--){
        int t = i + 1;
        while(t <= dp2.size() - 1 && heights[t] >= heights[i]){
            t = dp2[t];
        }
        dp2[i] = t;
    }
    // printDp(dp1);
    // printDp(dp2);
    for (int i = 0 ; i < heights.size() ; i++){
        int left = dp1[i]; //左边第一个小于该元素的列索引
        int right = dp2[i]; //右边第一个小于该元素的列索引
        int w = right - left - 1;
        int sum = w * heights[i];
        result = result > sum ? result : sum;
    }
    return result;
    }
};