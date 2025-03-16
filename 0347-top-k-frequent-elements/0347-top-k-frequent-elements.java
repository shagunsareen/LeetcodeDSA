class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(k == nums.length)
        {
            return nums;
        }

        int n = nums.length;
        //we need frequency of each element 
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        //now fetch top k elements as per the frequency
        //put all elements into the minHeap and fetch top k elements from top
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> freqMap.get(n1) - freqMap.get(n2)); //this means smaller freq element should be fetched first

        //maintain size k of the minheap O(Nlogk)
        for(int key : freqMap.keySet()){ //inserting keys in the minheap which is sorted by values/freq of elements
            minHeap.add(key);

            if(minHeap.size() > k){
                minHeap.poll(); //maintain k size minheap
            }
        }

        List<Integer> res = new ArrayList<>();
        while(k > 0){
            res.add(minHeap.poll());
            k--;
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}