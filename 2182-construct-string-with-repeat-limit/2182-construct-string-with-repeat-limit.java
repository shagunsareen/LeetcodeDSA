class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        //store the frequency of each character 
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1); 
        }
        
        //since we need lexicographically largest string so we need to pick largest char first 
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> b-a);
        pq.addAll(map.keySet());
        
        StringBuilder sb = new StringBuilder();
        
        while(pq.size() > 0){
            char curr = pq.poll();
            int freq = map.get(curr);
            int k = repeatLimit;
        
            while(k != 0 && freq > 0){
                sb.append(curr);
                k--;
                freq--;
            }
            
            map.put(curr, freq);

            //suppose repeatLimit is over but the freq is still pending then we pick the next greater element in the queue        
            if(freq > 0 && pq.size() > 0){
                char secChar = pq.poll();
                int secCharFreq = map.get(secChar);
                
                if(secCharFreq > 0){
                    sb.append(secChar);
                    map.put(secChar, secCharFreq - 1);
                }
                
                pq.add(curr);
                if(map.get(secChar) > 0){
                    pq.add(secChar);
                }
            }   
        }
        
        return sb.toString();
    }
}