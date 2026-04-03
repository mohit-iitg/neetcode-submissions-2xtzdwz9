class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        Set<String> dict = new HashSet<String>();
        for(String word: wordDict) {
            dict.add(word);
        }
        return helper(dp, dict, s, n) == 1?true:false;
    }

    private int helper(int[] dp, Set<String> dict, String s, int index) {
        if(index == 0) return 1;

        if(dp[index] != -1) return dp[index];

        int end = index;
        int possible = 0;
        for(int start = index-1; start>=0; start--) {
            if(dict.contains(s.substring(start, end))) {
                possible = helper(dp, dict, s, start);
                if(possible == 1) break;
            }
        }
        dp[index] = possible;
        return dp[index];
    }
}
