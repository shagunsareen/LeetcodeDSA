class Solution {
    public List<List<String>> groupAnagrams(String[] strs) { 
        //we make string of count of every char then we keep it as key in map and store all strings for same key 
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];

        for(String str : strs){
            Arrays.fill(count, 0);
            for(char ch : str.toCharArray()){
                count[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder("");
            for(int i=0; i<26; i++){
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();

            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
            }

            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}