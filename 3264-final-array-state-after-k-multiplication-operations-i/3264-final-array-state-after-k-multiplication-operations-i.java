class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] != b[0]) ? a[0] - b[0]  : a[1] - b[1]);
        
        //push all the elements to pq i.e. to min-heap 
        for(int i=0; i<nums.length; i++){
            pq.add(new int[]{nums[i], i});
        }
        
        //for k times get the min value 
        while(k>0){
            if(!pq.isEmpty()){
                int[] curr = pq.poll();
                int currEle = curr[0];
                int currIndex = curr[1];
                
                nums[currIndex] = currEle*multiplier;
                pq.add(new int[]{currEle*multiplier, currIndex});
            }
            k--;
        }
        
       return nums;
    }
}