class Solution {
    //TC : O(nlogk), SC:O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //insert only k numbers
        for(int num : nums){
            pq.add(num);

            if(pq.size() > k){
                pq.poll(); //remove min element
            }
        }   
        return pq.peek(); //since kth largest would be at top and lower elements would be 1st, 2nd, 3rd..k-1th largest  
    }
}