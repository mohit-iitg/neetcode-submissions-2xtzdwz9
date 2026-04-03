class Solution {
    public int maxProduct(int[] nums) {
        int currMin = 1, currMax = 1;
        int res = nums[0];
        for(int i=0;i<nums.length;i++) {
            res = Math.max(res, nums[i]);
        }

        for(int num : nums) {
            if(num == 0) {
                currMin = 1;
                currMax = 1;
                continue;
            }
            int tmp = currMax;
            currMax = Math.max(Math.max(num*currMax, num*currMin), num);
            currMin = Math.min(Math.min(num*tmp, num*currMin), num);
            res = Math.max(currMax, res);
        }

        return res;
    }
}