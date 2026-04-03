class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int[] row:dp) {
            Arrays.fill(row, -1);
        }

        return helper(dp, text1, text2, len1, len2);
    }

    private int helper(int[][] dp, String str1, String str2, int index1, int index2) {
        if(index1 == 0 || index2 == 0) return 0;

        if(dp[index1][index2] != -1) return dp[index1][index2];

        if(str1.charAt(index1-1) == str2.charAt(index2-1)) {
            return dp[index1][index2] = 1+helper(dp, str1, str2, index1-1, index2-1);
        } else {
            return dp[index1][index2] = Math.max(helper(dp, str1, str2, index1-1, index2), helper(dp, str1, str2, index1, index2-1));
        }
    } 
}
