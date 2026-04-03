class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        // if last one robbed
        int lastRobbed = nums[n-1] + helper(dp1, nums, n-3, 1);
        int lastNotRobbed = helper(dp2, nums, n-2, 0);
        
        return Math.max(lastRobbed, lastNotRobbed);
    }

    private int helper(int[] dp, int[] nums, int houseIndex, int startIndex) {
        if(houseIndex < startIndex) return 0;

        if(dp[houseIndex] != -1) return dp[houseIndex];

        int robbed = nums[houseIndex] + helper(dp, nums, houseIndex-2, startIndex);
        int notRobbed = helper(dp, nums, houseIndex-1, startIndex);

        dp[houseIndex] = Math.max(robbed, notRobbed);

        return dp[houseIndex];
    }
}
