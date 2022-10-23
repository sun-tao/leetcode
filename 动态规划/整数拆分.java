import static java.lang.System.out;
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2 ; i <= n ; i++){
            for (int j = 1 ; j < i ; j++){
                dp[i] = Integer.max(Integer.max(j*(i-j) , j * dp[i-j]),dp[i]);
            }
        }
        return dp[n];
    }
}