class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return helper(dp, s, n-1);
    }

    private int helper(int[] dp, String s, int index) {
        if(index < 0) return 1;

        if(dp[index] != -1) return dp[index];

        int ways = 0;
        if(isValid(s, index)) {
            ways += helper(dp, s, index-1);
        }

        if(index-1 >= 0 && isValid(s, index-1, index)) {
            ways += helper(dp, s, index-2);
        }

        dp[index] = ways;
        return ways;
    }

    private boolean isValid(String s, int index) {
        if(s.charAt(index) == '0') return false;
        return true;
    }

    private boolean isValid(String s, int start, int end) {
        if(s.charAt(start) == '0') return false;
        int num = Integer.valueOf(s.substring(start, end+1));
        if(num <= 26 && num >= 1) return true;
        return false; 
    }
}
