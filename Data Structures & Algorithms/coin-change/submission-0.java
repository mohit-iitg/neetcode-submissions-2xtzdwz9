class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length, INF = 10000+2;
        int[][] dp = new int[n+1][amount+1];

        for(int i=1;i<=amount;i++) {
            dp[0][i] = INF;
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=amount;j++) {
                dp[i][j] = dp[i-1][j];
                if(coins[i-1] <= j) {
                    if(dp[i][j-coins[i-1]] != -1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i-1]] + 1);
                    }
                }
            }
        }

        return dp[n][amount] == INF?-1:dp[n][amount];
    }
}
