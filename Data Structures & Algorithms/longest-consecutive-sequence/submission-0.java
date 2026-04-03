class Solution {
    class Pair {
        public int start;
        public int end;

        Pair(int s, int e) {
            this.start = s; this.end = e;
        }
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Pair> mp = new HashMap<>();
        int maxLen = 0;

        for(int num:nums) {
            // if there exists the exact number, no change in pair
            if(mp.containsKey(num)) continue;

            Pair lessPair = mp.get(num-1);
            Pair morePair = mp.get(num+1);

            if (lessPair != null && morePair != null) {
                // if both less and more number exists, then combine the pairs
                lessPair.end = morePair.end;
                mp.put(num+1, lessPair);
                maxLen = Math.max(maxLen, lessPair.end - lessPair.start + 1);
            } else if (lessPair != null) {
                // if there exists a number less, use the same pair, change values
                lessPair.end = num;
                mp.put(num, lessPair);
                maxLen = Math.max(maxLen, lessPair.end - lessPair.start + 1);
            } else if (morePair != null) {
                // if there exists a number more, use the same pair, change values
                morePair.start = num;
                mp.put(num, morePair);
                maxLen = Math.max(maxLen, morePair.end - morePair.start + 1);
            } else {
                // no pair exists, create a new entry
                Pair newPair = new Pair(num, num);
                mp.put(num, newPair);
                maxLen = Math.max(maxLen, 1);
            }
            // we dont need to change all the numbers pairs as long as
            // some pair has the exact pair that we need
        }

        return maxLen;
    }
}
