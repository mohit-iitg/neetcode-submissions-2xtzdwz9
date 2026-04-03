class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int maxLen = -1;
        for(int i=n-1;i>=0;i--) {
            maxLen = Math.max(maxLen, helper(dp, nums, i));
        }

        return maxLen;
    }

    private int helper(int[] dp, int[] nums, int index) {
        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];

        dp[index] = 1;
        for(int i=index-1;i>=0;i--) {
            if(nums[index] > nums[i] && dp[index] < 1 + helper(dp, nums, i)) {
                dp[index] = 1 + helper(dp, nums, i);
            }
        }

        return dp[index];
    }
}
