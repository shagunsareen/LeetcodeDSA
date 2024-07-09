class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length()>s.length()){
            return result;
        }
        
        Map<Character, Integer> pMap = new HashMap<>();
        int n = p.length();
        
        for(int k=0; k<n; k++){
            char ch = p.charAt(k);
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }
        
        Map<Character, Integer> sMap = new HashMap<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }
        
        //System.out.println(sMap);
        //start index : outgoing element index , end index : incoming element index
        
        int start = 0;
        int end = n;
        while (end<s.length()){
            //check hashmaps are equal or not
            if(pMap.equals(sMap))
                result.add(start);
            
            //reduce frequency of outgoing element
            char outgoing = s.charAt(start);
            char incoming = s.charAt(end);
            
            if(sMap.containsKey(outgoing)){
                 int freq = sMap.get(outgoing);
                 sMap.put(outgoing, freq-1);
                 if(freq-1==0)
                     sMap.remove(outgoing);
            }
              
            sMap.put(incoming, sMap.getOrDefault(incoming, 0) + 1);   
            start++;
            end++;
        }
        
        if(pMap.equals(sMap))
            result.add(start);
        
        return result;
    }
}