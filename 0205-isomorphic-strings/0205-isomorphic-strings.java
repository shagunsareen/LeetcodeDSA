class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        
        for(int i=0; i<s.length(); i++){
            char currChar = s.charAt(i);
            char mappingChar = t.charAt(i);
            
            if(map.containsKey(currChar))
            {
                if(!(map.get(currChar) == mappingChar))
                {
                    return false;
                }
            }else if(set.contains(mappingChar))
            {
                    return false;
            }
            
            map.put(currChar, mappingChar);
            set.add(mappingChar);
        }
        return true;  
    }
}

 /*if(!map.containsKey(currChar) && !map.containsValue(currChar))
            {
                map.put(currChar, mappingChar);
                flag = true;
                System.out.println("1 : " +flag);
            }else if(!map.isEmpty() 
                     && (map.containsKey(currChar) && map.get(currChar) == mappingChar)  
                     || (map.containsValue(currChar) && map.get(mappingChar) == currChar))
            {
                flag = true;
                System.out.println("2 : " +flag);
            }else{
                flag = false;
                System.out.println("3 : " +flag);
                break;
            }*/