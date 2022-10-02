import static java.lang.System.out;
class Solution {
    private List<List<String>> result = new ArrayList<>();
    private boolean[][] dp;
    private boolean is_huiwen(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private void is_huiwen_dp(String s){
        // dp[i][j]:以i为开头，j为结尾的子串是否是回文串，左闭右闭区间
        int size = s.length();
        for (int i = size - 1; i >= 0 ; i--){
            for (int j = i ; j < size ; j++){
                if (i+1 <= j-1 && dp[i+1][j-1] == false){
                    dp[i][j] = false;
                }
                else if (i+1 <= j-1 && dp[i+1][j-1] == true){
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? true : false;
                }
                else if (i+1 > j-1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? true : false;
                }
            }
        }
    }
    private void backtracking(String s,int startIndex,List<String> plan,int lastSplit){
        // 边界条件,先不考虑剪枝,把所有的分割方案列出,ok,模拟分割过程完成
        // if (plan.size() != 0 && !is_huiwen(plan.get(plan.size()-1))){
        //     return;
        // }
        if (startIndex >= s.length()){
            result.add(new ArrayList<>(plan));
            return;
        }
        for(int i = startIndex ; i < s.length() ; i++){
            if (dp[lastSplit][i] == false){
                continue;
            }
            String element = s.substring(lastSplit,i+1);
            plan.add(element);
            int temp = lastSplit;
            lastSplit = i+1;
            backtracking(s,i+1,plan,lastSplit);
            lastSplit = temp;
            plan.remove(plan.size()-1);
        }
        return;
    }
    public List<List<String>> partition(String s) {
        List<String> plan = new ArrayList<>();
        // backtracking(s,0,plan,0);
        dp = new boolean[s.length()][s.length()];
        is_huiwen_dp(s);
        backtracking(s,0,plan,0);
        return result;
    }
}