class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        ArrayList<Integer> currList = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        //put all integers in map
        for(int i=0; i<nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        
        permute(res, currList, freqMap, nums);
        
        return res;
    }
    
    private void permute(List<List<Integer>> res, ArrayList<Integer> currList, HashMap<Integer, Integer> freqMap, int[] nums){
        int n = nums.length;
        
        //Base condition
        if(currList.size() == nums.length){
            res.add(new ArrayList<>(currList));
            return;
        }
        
        for(int freqKey : freqMap.keySet()){
            if(freqMap.get(freqKey) > 0){
                currList.add(freqKey);
                freqMap.put(freqKey, freqMap.getOrDefault(freqKey, 0) - 1); //reduce the frequency
                
                permute(res, currList, freqMap, nums);
                
                currList.remove(currList.size() - 1);
                freqMap.put(freqKey, freqMap.getOrDefault(freqKey, 0) + 1); //increase the frequency
            }
        }
    }
    
}