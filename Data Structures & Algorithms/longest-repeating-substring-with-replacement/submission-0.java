class Solution {
    private boolean isValid(Map<Character, Integer> freqMap, int k) {
        int maxCount = 0, totalCount = 0;
        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());
            totalCount += entry.getValue();
        }
        return ((totalCount - maxCount) <= k) ? true : false;
    }

    private int totalLength(Map<Character, Integer> freqMap) {
        int len = 0;

        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            len+=entry.getValue();
        }

        return len;
    }
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int start = 0, end = 0, len = s.length(), maxLen = 0;

        while(end < len) {
            freq.put(s.charAt(end), freq.getOrDefault(s.charAt(end), 0) + 1);
            while(start < end && !isValid(freq, k)) {
                Character startCh = s.charAt(start);
                freq.put(startCh, freq.get(startCh)-1);
                if(freq.get(startCh) == 0) freq.remove(startCh);
                start++;
            }
            maxLen = Math.max(maxLen, totalLength(freq));
            end++;
        }

        return maxLen;
    }
}
