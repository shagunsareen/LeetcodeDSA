class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Approach 1 : TC : O(n*klogk)
        //Sort string and store it as key of map, then store all strings whose key is same in the map 
        Map<String, List<String>> map = new HashMap<>();
        //iterate over all strings and collect strings with same sorted key
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedStr = String.valueOf(ch);
        
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(map.values());
        
        
        //Approach 2 : 
    }
}