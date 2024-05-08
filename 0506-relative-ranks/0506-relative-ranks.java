class Solution {
    public String[] findRelativeRanks(int[] score) {
        int N = score.length;
        
        //Create a max heap of pairs (score, index)
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(
            (a,b) -> b.getKey() - a.getKey());
        
        for(int i=0; i<score.length; i++){
            heap.add(new Pair<>(score[i], i)); //this stores score and their original index
        }
        
        
        //now that the heap is sorted as decreading order of scores we will have ranks in increasing order
        //map ranks to athletes
        String[] rank = new String[N];
        int position = 1;
        while(!heap.isEmpty()){
            Pair<Integer, Integer> pair = heap.poll();
            int originalIndex = pair.getValue();
            if(position == 1){
                rank[originalIndex] = "Gold Medal";
            }else if(position == 2){
                rank[originalIndex] = "Silver Medal";
            }else if(position == 3){
                rank[originalIndex] = "Bronze Medal";
            }else{
                rank[originalIndex] = String.valueOf(position);
            }
            position++;
        }
        
        return rank;
    }
}