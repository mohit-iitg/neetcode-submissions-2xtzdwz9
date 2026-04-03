class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        int[] result = new int[n];

        for(int i=0;i<n;i++) {
            leftProduct[i] = nums[i];
            rightProduct[n-i-1] = nums[n-i-1];
            if(i-1>=0) leftProduct[i] = leftProduct[i] * leftProduct[i-1];
            if(n-i<n) rightProduct[n-i-1] = rightProduct[n-i-1] * rightProduct[n-i];
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
