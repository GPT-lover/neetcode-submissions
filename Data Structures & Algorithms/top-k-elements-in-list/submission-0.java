class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0) +1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            Integer number = entry.getKey();
            Integer freq = entry.getValue();

            // If no list exists at this frequency yet make one
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(number);
        }

        int[] result = new int[k];
        int resultCount = 0; // Tracks how many elements we have added to result

        // 1. Iterate backwards from highest frequency bucket down to 0
        for (int i = buckets.length - 1; i >= 0; i--) {
            // 2. Check if the bucket has elements inside it
            if (buckets[i] != null) {
                // 3. Extract each number from the current bucket list
                for (int number : buckets[i]) {
                    result[resultCount++] = number;
                    
                    // 4. Return as soon as we collected exactly k items
                    if (resultCount == k) {
                        return result;
                    }
                }
            }
        }
        
        return result;
    }
}
