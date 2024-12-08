class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for(int num : arr){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        //put the values in a set
        Set<Integer> freqSet = new HashSet<>();
        
        for(int freq : freqMap.values()){
            freqSet.add(freq);
        }
        
        return freqMap.size() == freqSet.size();
    }
}