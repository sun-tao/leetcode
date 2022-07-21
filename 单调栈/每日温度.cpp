class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        //st为单调栈，维护了一个从栈顶到栈底的递增数组
        //若满足递增，则入栈，因为上面的小，所以必然不是下面元素的更高温度
        //若不满足递增，则将比当前元素小的全部弹出栈，因为这代表更高的温度来了
        stack<int> st;
        vector<int> result (temperatures.size() , 0);
        
        if (temperatures.size() == 0){
            return result;
        }
        st.push(0);
        for (int i = 1; i < temperatures.size() ; i++){
            while(!st.empty() && temperatures[st.top()] < temperatures[i]){
                //弹出栈顶元素
                int index = st.top();
                st.pop();
                result[index] = i - index;
            }
            st.push(i);
        }
        return result;
    }
};