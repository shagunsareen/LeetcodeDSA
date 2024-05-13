class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        //Approach 1 : TC : O(n*klogk)
        //Sort string and store it as key of map, then store all strings whose key is same in the map 
        //iterate over all strings and collect strings with same sorted key
        /*for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedStr = String.valueOf(ch);
        
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }*/
        
        
        //Approach 2 : Skip Sorting and Create your own string 
        for(String str : strs){
            //store freq of each ch and create a string out of that
            char[] ch = new char[26];
            for(char c : str.toCharArray()){
                ch[c-'a']++; //increasing freq of current character
            }
            String keyStr = String.valueOf(ch);
            map.computeIfAbsent(keyStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}