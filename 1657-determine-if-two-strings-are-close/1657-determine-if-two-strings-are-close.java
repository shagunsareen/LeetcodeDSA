class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        
        if(len1 != len2){
            return false;
        }
        
        Map<Character, Integer> freqMap1 = new HashMap<>();
        for(char c : word1.toCharArray()){
            freqMap1.put(c, freqMap1.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> freqMap2 = new HashMap<>();
        for(char c : word2.toCharArray()){
            freqMap2.put(c, freqMap2.getOrDefault(c, 0) + 1);
        }
        
        //check if chars are same in both words because if there is even one missing character then return false
        if(!freqMap1.keySet().equals(freqMap2.keySet())){
            return false;
        }
        
        List<Integer> freqList1 = new ArrayList<>(freqMap1.values());
        List<Integer> freqList2 = new ArrayList<>(freqMap2.values());

        Collections.sort(freqList1);
        Collections.sort(freqList2);

        return freqList1.equals(freqList2);
    }
}