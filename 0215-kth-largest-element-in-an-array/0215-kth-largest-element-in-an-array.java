class Solution {
    public int findKthLargest(int[] nums, int k) {
        //use priorityqueue to get kth largest element
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int res = Integer.MIN_VALUE;

        //insert elements in the pq 
        for(int num : nums){
            pq.add(num);
        }

        //pop k elements
        while(k > 0){
            res = pq.poll();
            k--;
        }

        return res;
    }
}