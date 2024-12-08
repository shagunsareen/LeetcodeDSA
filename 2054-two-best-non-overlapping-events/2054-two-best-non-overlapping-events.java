class Solution {
    public int maxTwoEvents(int[][] events) {
        
        //sort the array as per the start time 
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        
        int maxValue = 0;
        int maxSum = 0;
        
        //since we need to get 2 maxevents hence we can consider current window and previous window with highest value, to keep prev events data we can keep it in priority queue so that we can sort it by min end time 
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        
        //traverse for all events and see if the curr event when clubbed with prev events can give us maxSum
        for(int[] event : events){
            
            //update maxValue is there are previous events which are non overlapping
            while(!pq.isEmpty() && pq.peek().getKey() < event[0]){
                 maxValue = Math.max(maxValue, pq.peek().getValue());
                 pq.poll();
            }
         
            maxSum = Math.max(maxSum, event[2] + maxValue);
            pq.add(new Pair<>(event[1], event[2]));
        }
        
        return maxSum;
    }
}