class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        while(end < n){
            char curr = s.charAt(end);   
            while(set.contains(curr)){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(curr);
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}