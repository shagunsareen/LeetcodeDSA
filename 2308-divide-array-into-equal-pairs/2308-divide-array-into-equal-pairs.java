class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        //check if all elements have frequency as even
        for(Integer freq : freqMap.values()){
            if(freq % 2 != 0)
            {
                return false;
            }
        }

        return true;
    }
}