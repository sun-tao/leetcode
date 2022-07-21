class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
         //哈希表+单调栈
         //O(n)
        vector<int> result (nums1.size() , -1);
        if (nums2.size() == 0){
            return result;
        }
        stack<int> st;
        unordered_map<int,int> umap;
        st.push(nums2[0]);
        for (int i = 1 ; i < nums2.size() ; i++){
            while(!st.empty() && st.top() < nums2[i]){ // 弹栈
                int value = st.top();
                st.pop();
                umap[value] = nums2[i];
            }
            st.push(nums2[i]);
        }

        while(!st.empty()){
            umap[st.top()] = -1;
            st.pop();
        }

        for (int i = 0 ; i < nums1.size() ; i++){
            result[i] = umap[nums1[i]];
        }
        return result;
    }
};