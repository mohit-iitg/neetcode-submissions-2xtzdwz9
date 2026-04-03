class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(), i = 0;
        Boolean[] dp = new Boolean[n+1];

        Set<String> dict = new HashSet<String>();
        for(String word:wordDict) {
            dict.add(word);
        }

        dp[0] = true;
        while(i <= n) {
            if(dp[i]!=null && dp[i] == true) {
                int j=i;
                while(j < n) {
                    if(dict.contains(s.substring(i, j+1))) {
                        dp[j+1] = true;
                    }
                    j++;
                }
            } 
            i++;
        }

        return (dp[n] != null && dp[n] == true)?true:false;
    }
}
