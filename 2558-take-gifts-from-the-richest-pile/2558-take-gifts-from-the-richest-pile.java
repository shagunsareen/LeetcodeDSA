class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        //add elements to maxHeap to get the max value each time 
        for(int i : gifts)
        {
            maxHeap.add(i);
        }
        
        while(k>0){
           double sqrt =  Math.sqrt(maxHeap.poll());
           maxHeap.add((int)sqrt);
           k--;
        }
        
        long giftsLeft = 0;
        
        while(!maxHeap.isEmpty()){
            giftsLeft += maxHeap.poll();
        }
        
        return giftsLeft;
    }
}