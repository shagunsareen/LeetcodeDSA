class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        // Create a max heap using PriorityQueue with a custom comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        // Add all elements to the priority queue
        for(int i : happiness){
            pq.add(i); 
        }
        
        long sum = 0;
        int turns = 0;
        
        for(int i=0; i<k; i++){
            // Add the current highest value to the total happiness sum and remove it from the max heap 
            sum += Math.max(pq.poll() - turns, 0); 
            // Increment turns for the next iteration
            turns++;
        }
        
        return sum;
    }
}