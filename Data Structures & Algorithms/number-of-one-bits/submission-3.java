class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        while(n != 0) {
            count += (n & 1) == 1 ? 1 : 0;
            n = n >> 1;
        }
        return count;
    }
}
