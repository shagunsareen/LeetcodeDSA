class Solution {
    public int findKthLargest(int[] nums, int k) {

        // TC : O(NlogN) but if we use min heap it would be O(Nlogk)
        //use priorityqueue to get kth largest element
        /*PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
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

        return res;*/
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //insert elements in the pq 
        for(int num : nums){
            pq.add(num);

            if(pq.size() > k){
                pq.poll(); //deleting the min element so that the top element should be kth largest
            }
        }

        return pq.peek();
    }
}