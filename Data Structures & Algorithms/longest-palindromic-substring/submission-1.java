class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int leftIndex = -1, rightIndex = -1, maxLen = 0;
        for(int i=0;i<n;i++) {
            // expand for odd palindrome
            int left = i, right = i;
            while(left >= 0 && right < n) {
                if(s.charAt(left) == s.charAt(right)) {
                    if(maxLen < (right - left + 1)) {
                        maxLen = (right - left + 1);
                        leftIndex = left;
                        rightIndex = right;
                    }
                    left--; right++;
                } else {
                    break;
                }
            } 

            // expand for even palindrome
            left = i; right = i+1;
            while(left >= 0 && right < n) {
                if(s.charAt(left) == s.charAt(right)) {
                    if(maxLen < (right - left + 1)) {
                        maxLen = (right - left + 1);
                        leftIndex = left;
                        rightIndex = right;
                    }
                    left--; right++;
                } else {
                    break;
                }
            }
        }

        return s.substring(leftIndex, rightIndex+1);
    }
}
