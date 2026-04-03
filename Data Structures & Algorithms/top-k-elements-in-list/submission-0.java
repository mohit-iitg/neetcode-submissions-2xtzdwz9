class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if(minHeap.size() < k) {
                minHeap.add(new int[]{entry.getKey(), entry.getValue()});
            } else if(minHeap.peek()[1] < entry.getValue()) {
                minHeap.poll();
                minHeap.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        int[] result = new int[k];
        int i=0;
        while(!minHeap.isEmpty()) {
            result[i++] = minHeap.poll()[0];
        }

        return result;
    }
}
