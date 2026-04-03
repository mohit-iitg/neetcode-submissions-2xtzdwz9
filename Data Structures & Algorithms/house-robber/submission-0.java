class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        return helper(dp, nums, nums.length);
    }

    private int helper(int[] dp, int[] nums, int houseIndex) {
        if(houseIndex <= 0) return 0;

        if(dp[houseIndex] != -1) return dp[houseIndex];

        // for the current house, choice is to rob or not rob
        // if robbed, you can rob the next to adjacent
        int robbed = nums[houseIndex-1] + helper(dp, nums, houseIndex-2);
        // if not robbed, you can rob the next
        int notRobbed = helper(dp, nums, houseIndex-1);

        dp[houseIndex] = Math.max(robbed, notRobbed);
        return dp[houseIndex];
    }
}
