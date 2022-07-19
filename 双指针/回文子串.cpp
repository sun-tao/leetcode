class Solution {
public:
    int extend(const string& s , int i , int j){
        int res = 0;
        while(i >= 0 && j < s.size() && s[i] == s[j]){
            i--;
            j++;
            res++;
        }
        return res;
    }
    int countSubstrings(string s) {
        //双指针
        int result = 0;
        for (int i = 0 ; i < s.size() ; i++){
            result += extend(s,i,i);
            result += extend(s,i,i+1);
        }
        return result;
    }
};