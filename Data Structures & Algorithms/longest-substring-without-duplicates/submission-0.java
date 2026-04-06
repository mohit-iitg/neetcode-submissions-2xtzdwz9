class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        int start = 0, end = 0, n = s.length(), maxLen = 0;
        while(end < n) {
            if(indexMap.containsKey(s.charAt(end))) {
                int index = indexMap.get(s.charAt(end));
                if(index >= start) {
                    start = index+1;
                }
            }
            indexMap.put(s.charAt(end), end);
            maxLen = Math.max(maxLen, end-start+1);
            end++;
        }
        return maxLen;
    }
}
