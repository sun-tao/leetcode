//本题的关键在于想到按照列来遍历，找每一列上的雨水高度
class Solution {
public:
     int trap(vector<int>& height) {
         //按列遍历
         //提交超时,复杂度o(n^2)
         int result = 0;
         for (int i = 0 ; i < height.size() ; i++){
             if (i == 0 || i == height.size() - 1){
                 continue;
             }
             int leftmax = 0;
             int rightmax = 0;
             int slow = i-1;
             int fast = i+1;
             while(true){
                 if (slow < 0 && fast > height.size()-1){
                     break;
                 }
                 if (slow >= 0){
                     leftmax = leftmax > height[slow] ? leftmax : height[slow];
                     slow--;
                 }
                 if (fast <= height.size() - 1){
                     rightmax = rightmax > height[fast] ? rightmax : height[fast];
                     fast++;
                 }
             }
             int waterheight = min(leftmax,rightmax);
             if (waterheight > height[i]){
                 result += waterheight - height[i];
             }
         }
         return result;
     }
}