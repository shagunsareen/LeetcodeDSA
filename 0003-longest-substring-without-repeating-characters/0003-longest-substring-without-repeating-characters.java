class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0; //this will iterate over entire string
        int n = s.length();
        int ans = 0;

        Map<Character, Integer> map = new HashMap<>();  //character, lastIndexOfChar
        while(end < n){
            char ch = s.charAt(end);
            
            if(map.containsKey(ch)){  
                start = Math.max(start, map.get(ch) + 1); //whichever is later     
            }
            map.put(ch, end);
            end++;
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}