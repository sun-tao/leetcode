class Solution {
public:
int largestRectangleArea(vector<int>& heights) {
        //对于任意列，固定其高度，找到其合法的最大宽度，即可得到该列对应的最大面积
        //全局最大面积一定从任意列的最大面积中得到，因此只需要对每个列的最大面积求最大值即可
        //
        //双指针
        //O(n^2)
        //找该列两侧第一个高度小于该列的列的索引
        int result = 0;
        for (int i = 0 ; i < heights.size() ; i++){
            int left = i - 1;
            int right = i + 1;
            for (;left >= 0 ; left--){
                if (heights[left] < heights[i]){
                    break;
                }
            }
            for (;right < heights.size() ; right++){
                if (heights[right] < heights[i]){
                    break;
                }
            }
            int w = right - left - 1;
            int sum = w * heights[i]; //该列的最大面积
            result = result > sum ? result : sum;
        }
        return result;
    }
}