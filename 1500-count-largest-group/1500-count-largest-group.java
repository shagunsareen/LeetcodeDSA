class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxValue = 0;
        //calculate sum of every number and then insert it in hashmap
        for(int i=1; i<=n; i++){
            int num = i;
            int sum = 0;
            while(num > 0){     
                int rem = num % 10;
                sum += rem;
                num = num/10;
            }

            freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);
            maxValue = Math.max(maxValue, freqMap.get(sum));
        }

        //iterate over map to know how many keys have groups of largest size 
        int count = 0;
        for(Map.Entry<Integer, Integer> kvPair : freqMap.entrySet()){
            if(kvPair.getValue() == maxValue){
                count++;
            }
        }
        return count;
    }
}