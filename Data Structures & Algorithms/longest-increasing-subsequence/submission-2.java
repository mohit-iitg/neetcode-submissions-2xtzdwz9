class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, maxLen = 1;
        int[] dp = new int[n];

        for(int i=0;i<n;i++) {
            dp[i] = 1;
            for(int j=i-1; j>=0; j--) {
                if(nums[i] > nums[j] && dp[i] < 1 + dp[j]) {
                    dp[i] = 1+dp[j];
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
