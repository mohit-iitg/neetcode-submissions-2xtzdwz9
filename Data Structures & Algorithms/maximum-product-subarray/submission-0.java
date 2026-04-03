class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = -100000, n = nums.length;

        for(int i=0;i<n;i++) {
            int prod = 1;
            for(int j=i;j<n;j++) {
                prod *= nums[j];
                maxProduct = Math.max(maxProduct, prod);
            }
        }

        return maxProduct;
    }
}
