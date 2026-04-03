class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length, INF = amount + 1;
        int[] dp = new int[amount+1];

        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int i=0;i<n;i++) {
            for(int j=1;j<=amount;j++) {
                if(coins[i] <= j) {
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                }
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }
}
