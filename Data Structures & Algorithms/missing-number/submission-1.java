class Solution {
    public int missingNumber(int[] nums) {
        int xored = 0, n = nums.length;
        for(int i=0;i<=n;i++) {
            xored = xored ^ i;
        }

        for(int i=0;i<n;i++) {
            xored = xored ^ nums[i];
        }
        return xored;
    }
}
