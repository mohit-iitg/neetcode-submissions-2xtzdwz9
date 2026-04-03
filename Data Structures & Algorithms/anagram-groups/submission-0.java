class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> sortedIndex = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String str:strs) {
            String key = keyParser(str);
            if(sortedIndex.containsKey(key)) {
                int index = sortedIndex.get(key);
                result.get(index).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);
                sortedIndex.put(key, result.size()-1);
            }
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
            sb.append(String.valueOf(f));
            sb.append(":");
        }

        return sb.toString();
    }
}
