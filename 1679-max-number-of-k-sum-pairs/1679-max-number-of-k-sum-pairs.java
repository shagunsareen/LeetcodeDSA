class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        
        //freqMap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num : nums){
            int pendingSum = k-num;
            
            //check if k-num is present in map 
            if(map.containsKey(pendingSum)){
                count++;
                
                //check freq and decrease it or if after decrememt it is 0 then remove it
                int freq = map.get(pendingSum);
                if(freq==1){
                    map.remove(pendingSum); //remove 
                }else{
                    map.put(pendingSum, freq-1); //decrement freq
                }
            }else{
               map.put(num, map.getOrDefault(num, 0)+1); 
            }
        }
        
        return count;
    }
}