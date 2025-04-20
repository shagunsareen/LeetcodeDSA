class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for(int ele : answers){
            if(ele == 0){ //there is only 1 person with this color as 0 eles are reported by this rabbit with same color so count this curr rabbit
                count++;
            }else{
                //update freq of the element
                freqMap.put(ele, freqMap.getOrDefault(ele, 0) + 1);

                if(freqMap.get(ele) == ele + 1){ //if count of curr ele is ele + 1 meaning all same colored rabbits are found then window for this color is complete 
                    count += ele + 1; 
                    //make that rabbit group freq as 0 now 
                    freqMap.put(ele, 0);
                }
            }
        }

        //some elements in map might be left out for whom all rabbits are not asked the question , we update count for those rabbits as well
       for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(freq > 0){
                count += key + 1;
            }
       }

       return count;
    }
}