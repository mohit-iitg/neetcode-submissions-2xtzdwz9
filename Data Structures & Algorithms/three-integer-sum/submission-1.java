class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n;i++) {
            while(i>0 && i<n && nums[i] == nums[i-1]) i++;

            int left = i+1, right = n-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(nums[left]); list.add(nums[right]);
                    result.add(list);
                    while(left < right && nums[left+1] == nums[left]) left++;
                    while(left < right && nums[right-1] == nums[right]) right--;

                    left++; right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
