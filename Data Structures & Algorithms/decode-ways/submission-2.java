class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0]=1;

        for(int i=0;i<n;i++) {
            if(isValid(s, i)) {
                dp[i+1] += dp[i];
            }
            if(i-1 >= 0 && isValid(s, i-1, i)) {
                dp[i+1] += dp[i-1];
            }
        }

        return dp[n];
    }

    private boolean isValid(String s, int index) {
        if(s.charAt(index) == '0') return false;
        return true;
    }

    private boolean isValid(String s, int start, int end) {
        if(s.charAt(start) == '0') return false;
        int num = (s.charAt(start) - '0') * 10 + (s.charAt(end) - '0');
        if(num <= 26 && num >= 1) return true;
        return false; 
    }
}
