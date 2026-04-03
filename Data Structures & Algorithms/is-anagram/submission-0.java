class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == 0) return true;

        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for(int i=0;i<s.length();i++) {
            freqS[s.charAt(i) - 'a']++;
            freqT[t.charAt(i) - 'a']++;
        }

        for(int i=0;i<26;i++) {
            if(freqS[i] != freqT[i]) return false;
            // System.out.print(freqS[i]+","+freqT[i]+" : ");
        }

        return true;
    }
}
