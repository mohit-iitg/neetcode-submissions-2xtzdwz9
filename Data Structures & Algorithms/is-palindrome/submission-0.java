class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i < j) {
            char ch_i = Character.toLowerCase(s.charAt(i));
            char ch_j = Character.toLowerCase(s.charAt(j));
            if(!Character.isLetterOrDigit(ch_i)) {
                i++;
            } else if(!Character.isLetterOrDigit(ch_j)) {
                j--;
            } else if(ch_i != ch_j) {
                return false;
            } else {
                i++; j--;
            }
        }

        return true;
    }
}
