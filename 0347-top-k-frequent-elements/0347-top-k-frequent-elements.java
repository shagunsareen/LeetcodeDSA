class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length){
            return nums;
        }

        //freq map 
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        //less frequent element first //ascending order 
        Queue<Integer> queue = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

        //keep only k elements in the queue 
        for(int num : count.keySet()){
            queue.add(num);
            if(queue.size() > k) {
                queue.poll();
            }
        } //O(Nlogk)

        //insert these k elements in the resultant array 
        int[] ans = new int[k];
        for(int i=k-1; i>=0; i--){
            ans[i] = queue.poll();
        } //O(klogk)

        return ans;
    }
}