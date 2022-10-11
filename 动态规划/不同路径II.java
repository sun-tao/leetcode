import static java.lang.System.out;

class Solution {
    private void printDp(int[][] dp){
        for (int i = 0 ; i < dp.length ;i++){
            for (int j= 0 ; j < dp[i].length; j++){
                out.print(dp[i][j]);
            }
            out.println(" ");
        }
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int l = obstacleGrid.length;
        int w = obstacleGrid[0].length;
        int[][] dp = new int[l][w];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0 ; i < l ; i++){
            for (int j = 0 ; j < w ;j++){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0){
                    dp[i][j] =  obstacleGrid[0][0] == 1 ? 0 : 1;
                    continue;
                }
                else if (i == 0){
                    dp[i][j] = dp[i][j-1];
                    continue;
                }
                else if (j == 0){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
       // printDp(dp);
        return dp[l-1][w-1];
    }
}