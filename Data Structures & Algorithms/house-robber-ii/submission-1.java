class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        else if(n == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(robLinear(nums, 0, n-2), robLinear(nums, 1, n-1));
    }

    private int robLinear(int[] nums, int start, int end) {
        if(start == end) return nums[start];

        int rob1 = nums[start], rob2 = Math.max(nums[start], nums[start+1]);
        for(int i=start+2; i<=end; i++) {
            int newRob = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }

        return Math.max(rob1, rob2);
    }
}
