class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;

        for(int i=0;i<n;i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        // bucket of frequency
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            buckets.add(new ArrayList<Integer>());
        } 
        for(Map.Entry<Integer, Integer> entry:freq.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        int[] result = new int[k];
        for(int i=n, j=0;i>=0 && j < k;i--) {
            int bucketSize = buckets.get(i).size();
            for(int b_index=0;b_index<bucketSize;b_index++) {
                result[j++] = buckets.get(i).get(b_index);
                if(j == k) break;
            }
        }

        return result;
    }
}
