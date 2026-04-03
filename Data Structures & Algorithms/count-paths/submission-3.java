class Solution {
    public int uniquePaths(int m, int n) {
        int totalSpaces = m+n-2;
        int selectSpaces = ((m > n)?n:m) - 1;
        
        return nCr(totalSpaces, selectSpaces);
    }

    private int nCr(int n, int r) {
        int res = 1;
        for(int i=1;i<=r;i++) {
            res = res * (n - i + 1) / i;
        }
        return res;
    }
}
