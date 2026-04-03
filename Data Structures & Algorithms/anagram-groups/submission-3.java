class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedIndex = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String str:strs) {
            String key = keyParser(str);
            if(sortedIndex.containsKey(key)) {
                sortedIndex.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                sortedIndex.put(key, list);
            }
        }

        for(Map.Entry<String, List<String>> entry:sortedIndex.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    private String keyParser(String str) {
        int[] freq = new int[26];
        for(char ch:str.toCharArray()) {
            freq[ch-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int f:freq) {
            sb.append(f).append(":");
        }

        return sb.toString();
    }
}
