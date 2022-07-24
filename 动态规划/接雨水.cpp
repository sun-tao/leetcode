class Solution {
public:
    int trap(vector<int>& height){
        //动态规划
        //时间复杂度O(n)
        int result = 0;
        //dp_left[i]:以索引i为中心的左边的最大值
        //dp_right[i]:以索引i为中心的右边的最大值
        vector<int> dp_left (height.size(),0);
        vector<int> dp_right (height.size() , 0);
        //从左向右
        for (int i = 1 ; i < dp_left.size() ; i++){
            dp_left[i] = max(height[i-1],dp_left[i-1]);
        }
        //从右向左
        for (int i = dp_right.size() - 2 ; i >= 0 ; i--){
            dp_right[i] = max(height[i+1],dp_right[i+1]);
        }
        // printDp(dp_left);
        // printDp(dp_right);
        //收集雨水
        for (int i = 0 ; i < height.size() ; i++){
            if (i == 0 || i == height.size() - 1){
                continue;
            }
            int leftMax = dp_left[i];
            int rightMax = dp_right[i];
            int waterHeight = min(leftMax,rightMax);
            if (waterHeight - height[i] > 0){
                result += waterHeight - height[i];
            }
        }
    return result;
   }
}