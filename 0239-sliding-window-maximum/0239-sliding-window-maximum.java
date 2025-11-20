class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //we can not use normal sliding window alone as for input 100,99,98,.. max will be recomputed every time an element is left out from window hence tc - O(n*k) = 10^10 
        //using priority queue will take logK time to sort k elements in max heap which gives tc - O(nlogK) which is still not most optimal 
        
        /*** DEQUE APPROACH ***/
        //so we use deque to behave as max heap which gives us max for every k elements 
        
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        //iterate over entire nums array and keep putting in deque, delete ele smaller in deque than curr ele
        //keep size of deque as k

        for(int i=0; i<n; i++){
            int curr = nums[i];

            while(!dq.isEmpty() && dq.peekFirst() <= i-k ){ //remove elements out of window from front, since i is curr index the window will start from i-k+1 hence any element before this i.e. i-k is out of window and is invalid 
                dq.pollFirst(); 
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < curr){ //remove smaller elements from back
                dq.pollLast();
            }

            dq.offerLast(i); //add current index

            //window has formed so record max value 
            if(i >= k - 1){
                res.add(nums[dq.peekFirst()]);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}