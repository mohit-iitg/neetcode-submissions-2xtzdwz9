class Solution {
    private Character delim = '#';
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str:strs) {
            int len = str.length();
            sb.append(String.valueOf(len));
            sb.append(delim);
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();
        int i=0;
        while(i<str.length()) {
            int begin = i, end = i;
            while(end < str.length() && str.charAt(end) != delim) {
                end++;
            }

            int len = Integer.valueOf(str.substring(begin, end));
            String word = str.substring(end+1, end+len+1);
            result.add(word);
            i=end+len+1;
        }
        return result;
    }
}
