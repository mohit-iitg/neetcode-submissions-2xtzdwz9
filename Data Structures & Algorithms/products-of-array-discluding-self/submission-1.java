class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        int[] result = new int[n];

        leftProduct[0] = nums[0];
        for(int i=1;i<n;i++) {
            leftProduct[i] = nums[i];
            leftProduct[i] = leftProduct[i] * leftProduct[i-1];
        }

        rightProduct[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--) {
            rightProduct[i] = nums[i];
            rightProduct[i] = rightProduct[i] * rightProduct[i+1];
        }

        for(int i=0;i<n;i++) {
            result[i] = 1;
            if(i-1>=0) {
                result[i] = leftProduct[i-1] * result[i];
            }
            if(i+1<n) {
                result[i] = rightProduct[i+1] * result[i];
            }
        }

        return result;
    }
}  
