class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        boolean[] marked = new boolean[nums.length];
        
        //take a min heap to maintain smallest integer unmarked from the array and store the index as well so that we can return min index element, arr[] will have {element, index}
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((arr1, arr2) -> {
            if(arr1[0] != arr2[0]) return arr1[0] - arr2[0];
            return arr1[1]-arr2[1];    //returns smallest index element
        });
        
        //insert all elements to heap
        for(int i=0; i<nums.length; i++){
            pq.add(new int[]{ nums[i], i });
        }
        
        //now pick smallest elements and add it to the score
        while(!pq.isEmpty()){
            
            int[] curr = pq.poll();
            int element = curr[0];
            int index = curr[1];
            
            //check if this is not marked
            if(!marked[index]){
                marked[index] = true;
                 score += element;
                //check if adjacent ele are present mark them as well
                if(index + 1 < nums.length){
                    marked[index + 1] = true;
                }

                if(index - 1 >= 0){
                    marked[index - 1] = true;
                }
            }
           
            
        }
        return score;
    }
}